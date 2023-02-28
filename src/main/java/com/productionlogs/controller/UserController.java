package com.productionlogs.controller;

import com.productionlogs.dto.UserDto;
import com.productionlogs.entity.User;
import com.productionlogs.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/newUser")
    public String newUser(@ModelAttribute("newUser") UserDto userDto) {
        return "user/newUser";
    }

    @PostMapping("/newUser")
    public String newUser(@Valid @ModelAttribute("newUser") UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/newUser";
        }
        User user = userService.mapToUser(userDto);
        userService.save(user);
        return "redirect:/";
    }
}
