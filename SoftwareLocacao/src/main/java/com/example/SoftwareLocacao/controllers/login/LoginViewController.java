package com.example.SoftwareLocacao.controllers.login;


import com.example.SoftwareLocacao.repositories.UsuarioAdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/login")
public class LoginViewController {

    @Autowired
    private UsuarioAdministradorRepository administradorRepository;

    @GetMapping()
    public String login(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping
    public String processLogin(@RequestParam String nome, @RequestParam String senha) {

        if (1==1) {
            return "redirect:/home";
        } else {

            return "redirect:/login?error=1";
        }
    }
}