package com.example.SoftwareLocacao.controllers;


import com.example.SoftwareLocacao.models.UsuarioAdministrador;
import com.example.SoftwareLocacao.services.UsuarioAdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarioAdministrador") //rota da controller
public class UsuarioController{

    @Autowired
    private UsuarioAdministradorService usuarioAdministradorService;

    @GetMapping("/{id}")// o {} é para avisar que um parâmetro será passado
    public ResponseEntity<UsuarioAdministrador> findUsuarioById(@PathVariable Long id){
        UsuarioAdministrador usuario = this.usuarioAdministradorService.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping
    public ResponseEntity<String> createUsuario(@RequestBody UsuarioAdministrador obj){
        try{
            this.usuarioAdministradorService.create(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                    buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception ex){
            String errorMessage = "Erro ao criar usuário administrador: " + ex.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUsuario(@RequestBody UsuarioAdministrador obj, @PathVariable Long id){
        obj.setId(id);
        try{
            this.usuarioAdministradorService.update(obj);
            return ResponseEntity.noContent().build();
        } catch(Exception ex){
            String errorMessage = "Erro ao atualizar usuário administrador: " + ex.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id){
        try{
            this.usuarioAdministradorService.delete(id);
            return ResponseEntity.noContent().build();
        } catch(Exception ex){
            String errorMessage = "Erro ao deletar usuário administrador: " + ex.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }

    }

}
