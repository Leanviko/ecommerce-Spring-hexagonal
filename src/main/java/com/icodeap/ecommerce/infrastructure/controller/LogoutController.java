package com.icodeap.ecommerce.infrastructure.controller;

import com.icodeap.ecommerce.application.service.LogoutService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/close")
public class LogoutController {
    private final LogoutService logoutService;

    public LogoutController(LogoutService logoutService) {
        this.logoutService = logoutService;
    }

    @GetMapping
    public String logout(HttpSession httpSession){
        logoutService.logout(httpSession);
        return  "redirect:/home";
    }
}
