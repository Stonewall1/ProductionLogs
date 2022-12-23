package com.productionlogs.controller;

import com.productionlogs.dto.R1Dto;
import com.productionlogs.entity.R1;
import com.productionlogs.service.R1Service;
import jakarta.validation.Valid;
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
    public String r1(R1Dto r1Dto, Model model) {
        model.addAttribute("allOps", r1Service.findAll());
        r1Dto.setOperationStart(LocalDateTime.now());
        r1Dto.setOperationFinish(LocalDateTime.now());
        model.addAttribute("newOp", r1Dto);
        return "equipment/reactor/r1";
    }

    @PostMapping("/r1")
    public String r1(@Valid @ModelAttribute("newOp") R1Dto r1Dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "equipment/reactor/r1";
        }
        R1 r1 = r1Service.map(r1Dto);
        r1Service.save(r1);
        return "redirect:/reactor/r1";
    }
}
