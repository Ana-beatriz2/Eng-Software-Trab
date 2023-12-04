package com.example.SoftwareLocacao.controllers;

import com.example.SoftwareLocacao.models.Carro;
import com.example.SoftwareLocacao.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

    @RestController
    @RequestMapping("/Carro")
    public class CarroController {

        @Autowired
        private CarroService carroService;

        @GetMapping("/{id}")
        public ResponseEntity<Carro> findCarroById(@PathVariable Long id){
            Carro carro = this.carroService.findCarroById(id);
            return ResponseEntity.ok().body(carro);
        }

        @PostMapping
        public ResponseEntity<String> createCarro(@RequestBody Carro obj){
            try{
                this.carroService.create(obj);
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                        buildAndExpand(obj.getId()).toUri();
                return ResponseEntity.created(uri).build();
            } catch (Exception ex){
                String errorMessage = "Erro ao criar carro: " + ex.getMessage();
                return ResponseEntity.badRequest().body(errorMessage);
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<String> updateCarro(@RequestBody Carro obj, @PathVariable Long id){
            obj.setId(id);
            try{
                this.carroService.updateCarro(obj);
                return ResponseEntity.noContent().build();
            } catch(Exception ex){
                String errorMessage = "Erro ao atualizar carro: " + ex.getMessage();
                return ResponseEntity.badRequest().body(errorMessage);
            }

        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteCarro(@PathVariable Long id){
            try{
                this.carroService.deletarCarro(id);
                return ResponseEntity.noContent().build();
            } catch(Exception ex){
                String errorMessage = "Erro ao deletar carro: " + ex.getMessage();
                return ResponseEntity.badRequest().body(errorMessage);
            }

        }
}
