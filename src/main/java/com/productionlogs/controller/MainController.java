package com.productionlogs.controller;

import com.productionlogs.service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    private final EquipmentService equipmentService;

    public MainController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public String homepage(Model model) {
        model.addAttribute("allEquipment", equipmentService.findAllEquipment());
        return "homepage";
    }
}
