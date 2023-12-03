package com.example.SoftwareLocacao.controllers.login;

import com.example.SoftwareLocacao.security.authentication.cookie.CookieService;
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
        CookieService.setCookie(response, "AdministradorId", "", 0);
        CookieService.setCookie(response, "AdministradorNome", "", 0);
        return "redirect:/login";
    }
}