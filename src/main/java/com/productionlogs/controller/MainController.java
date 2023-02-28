package com.productionlogs.controller;

import com.productionlogs.service.EquipmentService;
import com.productionlogs.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    private final EquipmentService equipmentService;
    private final UserService userService;

    public MainController(EquipmentService equipmentService, UserService userService) {
        this.equipmentService = equipmentService;
        this.userService = userService;
    }

    @GetMapping
    public String homepage(Model model) {
        model.addAttribute("allEquipment", equipmentService.findAllEquipment());
        /**
         * SecurityContextHolder test
         */
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username = ((UserDetails) principal).getUsername();
//        model.addAttribute("current", username);

        return "homepage";
    }

    @GetMapping("/login")
    public String login() {
        userService.createAdmin();
        return "login";
    }
}
