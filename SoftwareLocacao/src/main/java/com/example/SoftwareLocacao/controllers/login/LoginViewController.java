package com.example.SoftwareLocacao.controllers.login;


import com.example.SoftwareLocacao.models.UsuarioAdministrador;
import com.example.SoftwareLocacao.repositories.UsuarioAdministradorRepository;
import com.example.SoftwareLocacao.security.authentication.cookie.CookieService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping(value = {"/login"})
public class LoginViewController {

    @Autowired
    private UsuarioAdministradorRepository administradorRepository;

    @GetMapping()
    public String login(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping
    public String loginRequestForm(@ModelAttribute Login login, Model model, HttpServletResponse response) throws IOException {
        model.addAttribute("login", login);
        UsuarioAdministrador usuarioAdministrador = administradorRepository.findByNomeAndSenha(login.getNome().toUpperCase(), login.getSenha());

        if (usuarioAdministrador != null) {
            int tempoLogin = (60 * 60 * 30);
            CookieService.setCookie(response, "administradorId", String.valueOf(usuarioAdministrador.getId()), tempoLogin);
            CookieService.setCookie(response, "administradorNome", String.valueOf(usuarioAdministrador.getNome()), tempoLogin);

            return "redirect:/home";
        }
        return "redirect:/login?error";
    }
}