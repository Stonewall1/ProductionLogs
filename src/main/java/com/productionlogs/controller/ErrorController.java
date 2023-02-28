package com.productionlogs.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(RuntimeException.class)
    public String somethingWentWrong(RuntimeException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "somethingWentWrong";
    }
}
