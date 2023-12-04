package com.example.SoftwareLocacao.controllers.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/buscarUsuario")
public class BuscarUsuario {

    @GetMapping
    public String buscarUsuario(){
        return "buscarUsuario";
    }
}