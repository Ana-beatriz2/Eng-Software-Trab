package com.example.SoftwareLocacao.controllers;

import com.example.SoftwareLocacao.models.Filial;
import com.example.SoftwareLocacao.services.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/filial")
public class FilialController {

        @Autowired
        private FilialService filialService;

        @GetMapping("/{id}")
        public ResponseEntity<Filial> findFilialById(@PathVariable Long id){
            Filial filial = this.filialService.findFilialById(id);
            return ResponseEntity.ok().body(filial);
        }

        @PostMapping
        public ResponseEntity<String> createFilail(@RequestBody Filial obj){
            try{
                this.filialService.createFilial(obj);
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                        buildAndExpand(obj.getId()).toUri();
                return ResponseEntity.created(uri).build();
            } catch (Exception ex){
                String errorMessage = "Erro ao criar carro: " + ex.getMessage();
                return ResponseEntity.badRequest().body(errorMessage);
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteFilial(@PathVariable Long id){
            try{
                this.filialService.deleteFilial(id);
                return ResponseEntity.noContent().build();
            } catch(Exception ex){
                String errorMessage = "Erro ao deletar carro: " + ex.getMessage();
                return ResponseEntity.badRequest().body(errorMessage);
            }

        }
}
