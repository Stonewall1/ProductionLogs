package com.productionlogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @GetMapping("/newEquipment")
    public String newEquipment(){
        //toDo
        return "";
    }
    @PostMapping("/newEquipment")
    public String newEquipment(Model model){

        return "redirect:/";
    }
}
