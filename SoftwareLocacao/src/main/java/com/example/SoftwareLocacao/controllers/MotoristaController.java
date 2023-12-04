package com.example.SoftwareLocacao.controllers;

import com.example.SoftwareLocacao.models.Motorista;
import com.example.SoftwareLocacao.services.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @GetMapping("/{id}")
    public ResponseEntity<Motorista> findMotoristaById(@PathVariable Long id){
        Motorista motorista = this.motoristaService.findMotoristaById(id);
        return ResponseEntity.ok().body(motorista);
    }

    @PostMapping
    public ResponseEntity<String> createMotorista(@RequestBody Motorista obj){
        try{
            this.motoristaService.createMotorista(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                    buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception ex){
            String errorMessage = "Erro ao cadastrar motorista: " + ex.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMotorista(@RequestBody Motorista obj, @PathVariable Long id){
        obj.setId(id);
        try{
            this.motoristaService.updateMotorista(obj);
            return ResponseEntity.noContent().build();
        } catch(Exception ex){
            String errorMessage = "Erro ao atualizar motorista: " + ex.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMotorista(@PathVariable Long id){
        try{
            this.motoristaService.deleteMotorista(id);
            return ResponseEntity.noContent().build();
        } catch(Exception ex) {
            String errorMessage = "Erro ao deletar motorista: " + ex.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }
}
