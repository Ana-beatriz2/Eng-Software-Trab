package com.example.SoftwareLocacao.controllers;

import com.example.SoftwareLocacao.models.UsuarioCliente;
import com.example.SoftwareLocacao.services.UsuarioClienteService;
import com.example.SoftwareLocacao.services.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarioCliente")
public class UsuarioClienteController {

    @Autowired
    private UsuarioClienteService usuarioClienteService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioCliente> findUsuarioById(@PathVariable Long id){
        UsuarioCliente usuario = this.usuarioClienteService.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<UsuarioCliente> findClienteByName(@PathVariable String nome){
        UsuarioCliente usuario = this.usuarioClienteService.findClienteByName(nome);
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping
    public ResponseEntity<String> createUsuario(@RequestBody UsuarioCliente obj){
        try{
            this.usuarioClienteService.create(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                    buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception ex){
            String errorMessage = "Erro ao cadastrar cliente: " + ex.getMessage();
            throw new DataIntegrityViolationException(errorMessage);
        }
        /*this.usuarioClienteService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();*/

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUsuario(@RequestBody UsuarioCliente obj, @PathVariable Long id){
        obj.setId(id);
        try{
            this.usuarioClienteService.update(obj);
            return ResponseEntity.noContent().build();
        } catch(Exception ex){
            String errorMessage = "Erro ao atualizar usuário cliente: " + ex.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id){
        try{
            this.usuarioClienteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch(Exception ex) {
            String errorMessage = "Erro ao deletar usuário cliente: " + ex.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }
}
