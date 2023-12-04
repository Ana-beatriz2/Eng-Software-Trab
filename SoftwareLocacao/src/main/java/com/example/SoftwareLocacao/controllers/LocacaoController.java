package com.example.SoftwareLocacao.controllers;

import com.example.SoftwareLocacao.models.Locacao;
import com.example.SoftwareLocacao.services.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Locacao> findLocacaoById(@PathVariable Long id){
        Locacao locacao = this.locacaoService.findLocacaoById(id);
        return ResponseEntity.ok().body(locacao);
    }

    @GetMapping()
    public List<Locacao> findAll(){
        return this.locacaoService.findAllLocacoes();
    }

    @PostMapping
    public ResponseEntity<String> createLocacao(@RequestBody Locacao obj){
        try{
            this.locacaoService.createLocacao(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                    buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception ex){
            String errorMessage = "Erro ao criar locação: " + ex.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLocacao(@RequestBody Locacao obj, @PathVariable Long id){
        obj.setId(id);
        try{
            this.locacaoService.updateLocacao(obj);
            return ResponseEntity.noContent().build();
        } catch(Exception ex){
            String errorMessage = "Erro ao atualizar usuário administrador: " + ex.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocacao(@PathVariable Long id){
        try{
            this.locacaoService.deleteLocacao(id);
            return ResponseEntity.noContent().build();
        } catch(Exception ex){
            String errorMessage = "Erro ao deletar usuário administrador: " + ex.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }

    }
}
