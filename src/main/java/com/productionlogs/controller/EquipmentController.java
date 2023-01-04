package com.productionlogs.controller;

import com.productionlogs.constant.PageSizes;
import com.productionlogs.dto.EquipmentDto;
import com.productionlogs.dto.OperationDto;
import com.productionlogs.entity.Equipment;
import com.productionlogs.entity.Operation;
import com.productionlogs.service.EquipmentService;
import com.productionlogs.service.JournalService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {
    private final EquipmentService equipmentService;
    private final JournalService journalService;

    public EquipmentController(EquipmentService equipmentService, JournalService journalService) {
        this.equipmentService = equipmentService;
        this.journalService = journalService;
    }

    @GetMapping("/newEquipment")
    public String newEquipment(@ModelAttribute("newEquipment") EquipmentDto equipmentDto) {
        return "equipment/newEquipment";
    }

    @PostMapping("/newEquipment")
    public String newEquipment(@Valid @ModelAttribute("newEquipment") EquipmentDto equipmentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "equipment/newEquipment";
        }
        Equipment equipment = equipmentService.mapToEquipment(equipmentDto);
        equipmentService.save(equipment);
        return "redirect:/";
    }

    @GetMapping("/equipmentPage/{id}")
    public String equipmentPage(@PathVariable("id") long id, OperationDto operationDto, Model model,
                                @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = PageSizes.PAGE_SIZE) Pageable pageable) {
        model.addAttribute("equipment", equipmentService.findByID(id));

        Page<Operation> page = journalService.findAllOperationsByEquipmentID(pageable, id);
        model.addAttribute("allOps", page);
        operationDto.setOperationStart(LocalDateTime.now());
        operationDto.setOperationFinish(LocalDateTime.now());
        model.addAttribute("newOp", operationDto);
        model.addAttribute("url", "/equipment/equipmentPage/" + id);

        return "equipment/equipmentPage";
    }

    @PostMapping("/equipmentPage/{id}")
    public String equipmentPage(@PathVariable("id") long id, @Valid @ModelAttribute("newOp") OperationDto operationDto, BindingResult bindingResult, Model model,
                                @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = PageSizes.PAGE_SIZE) Pageable pageable) {
        if (bindingResult.hasErrors()) {
            Page<Operation> page = journalService.findAllOperationsByEquipmentID(pageable, id);
            model.addAttribute("equipment", equipmentService.findByID(id));
            model.addAttribute("allOps", page);
            model.addAttribute("newOp", operationDto);
            model.addAttribute("url", "/equipment/equipmentPage/" + id);
            return "equipment/equipmentPage";
        }
        Operation operation = journalService.map(operationDto);
        Equipment byID = equipmentService.findByID(id);
        operation.setEquipment(byID);
        journalService.save(operation);
        return "redirect:/equipment/equipmentPage/" + id;
    }
}
