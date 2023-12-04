package com.example.SoftwareLocacao.controllers.login;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/sair")
public class LogoutViewController {

    @GetMapping
    public String logout(HttpServletResponse response) throws IOException {
        return "redirect:/login";
    }
}