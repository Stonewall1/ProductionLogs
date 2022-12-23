package com.productionlogs.controller;

import com.productionlogs.entity.R1;
import com.productionlogs.repository.R1Repository;
import com.productionlogs.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    private final R1Repository r1Repository;
    private final UserRepository userRepository;

    public MainController(R1Repository r1Repository, UserRepository userRepository) {
        this.r1Repository = r1Repository;
        this.userRepository = userRepository;
    }


    @GetMapping
    public String homepage(Model model) {
        List<R1> all = r1Repository.findAll();
        model.addAttribute("allOps", all);
        return "homepage";
    }

    @GetMapping("/r1")
    public String r1(R1 r1, Model model) {
        r1.setOperationStart(LocalDateTime.now());
        r1.setOperationFinish(LocalDateTime.now());
        model.addAttribute("newOp", r1);
        return "r1";
    }

    @PostMapping("/r1")
    public String r1(@Valid @ModelAttribute("newOp") R1 r1, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "r1";
        }
        r1Repository.save(r1);
        return "redirect:/r1";
    }
}
