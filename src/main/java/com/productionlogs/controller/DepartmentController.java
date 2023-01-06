package com.productionlogs.controller;

import com.productionlogs.dto.DepartmentDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @GetMapping("/newDepartment")
    public String newEquipment(@ModelAttribute("newDepartment") DepartmentDto departmentDto) {
        return "department/newDepartment";
    }

    @PostMapping("/newDepartment")
    public String newEquipment(@Valid @ModelAttribute("newDepartment") DepartmentDto departmentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "department/newDepartment";
        }

        return "redirect:/";
    }
}
