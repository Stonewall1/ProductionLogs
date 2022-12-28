package com.productionlogs.controller;

import com.productionlogs.constant.PageSizes;
import com.productionlogs.dto.R1Dto;
import com.productionlogs.entity.R1;
import com.productionlogs.service.R1Service;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/reactor")
public class ReactorController {
    private final R1Service r1Service;

    public ReactorController(R1Service r1Service) {
        this.r1Service = r1Service;
    }

    @GetMapping("/r1")
    public String r1(R1Dto r1Dto, Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = PageSizes.PAGE_SIZE) Pageable pageable) {
        Page<R1> page = r1Service.findAll(pageable);
        model.addAttribute("allR1Ops", page);
        r1Dto.setOperationStart(LocalDateTime.now());
        r1Dto.setOperationFinish(LocalDateTime.now());
        model.addAttribute("newOp", r1Dto);
        model.addAttribute("url", "/reactor/r1");
        return "equipment/reactor/r1";
    }

    @PostMapping("/r1")
    public String r1(@Valid @ModelAttribute("newOp") R1Dto r1Dto, BindingResult bindingResult, Model model,
                     @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = PageSizes.PAGE_SIZE) Pageable pageable) {
        if (bindingResult.hasErrors()) {
            Page<R1> page = r1Service.findAll(pageable);
            model.addAttribute("allR1Ops", page);
            model.addAttribute("newOp", r1Dto);
            model.addAttribute("url", "/reactor/r1");
            return "equipment/reactor/r1";
        }
        R1 r1 = r1Service.map(r1Dto);
        r1Service.save(r1);
        return "redirect:/reactor/r1";
    }
}
