package com.productionlogs.controller;

import com.productionlogs.constant.PageSizes;
import com.productionlogs.dto.OperationDto;
import com.productionlogs.entity.Operation;
import com.productionlogs.service.EquipmentService;
import com.productionlogs.service.JournalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/journal")
public class JournalController {
    private final JournalService journalService;
    private final EquipmentService equipmentService;

    public JournalController(JournalService journalService, EquipmentService equipmentService) {
        this.journalService = journalService;
        this.equipmentService = equipmentService;
    }

    @PostMapping("/newOperation/{id}")
    public String newOperation(@PathVariable("id") long id, @Valid @ModelAttribute("newOp") OperationDto operationDto, BindingResult bindingResult, Model model,
                               @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = PageSizes.PAGE_SIZE) Pageable pageable) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("equipment", equipmentService.findByID(id));
            Page<Operation> page = journalService.findAllOperationsByEquipmentID(pageable, id);
            model.addAttribute("allOps", page);
            model.addAttribute("newOp", operationDto);
            model.addAttribute("url", "/equipment/equipmentPage/" + id);
            return "equipment/equipmentPage";
        }
        Operation operation = journalService.mapToOperationAndBindEquipment(operationDto, equipmentService.findByID(id));
        journalService.save(operation);
        return "redirect:/equipment/equipmentPage/" + id;
    }

    @PostMapping("/{equipmentId}/{operationId}/{page}/updateStatus")
    public String updateStatus(@PathVariable("equipmentId") long equipmentId,
                               @PathVariable("operationId") long operationId,
                               @PathVariable("page") int currentPage) {
        Operation byId = journalService.findById(operationId);
        journalService.changeOperationStatus(byId);
        return "redirect:/equipment/equipmentPage/".concat(String.valueOf(equipmentId)).concat("?page=").concat(String.valueOf(currentPage));
    }
}
