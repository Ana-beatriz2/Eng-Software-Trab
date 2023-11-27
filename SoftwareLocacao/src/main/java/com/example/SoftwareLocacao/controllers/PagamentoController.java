package com.example.SoftwareLocacao.controllers;

import com.example.SoftwareLocacao.models.Pagamento;
import com.example.SoftwareLocacao.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> findPagamentoById(@PathVariable Long id){
        Pagamento pagamento = this.pagamentoService.findPagamentoById(id);
        return ResponseEntity.ok().body(pagamento);
    }

    @PostMapping
    public ResponseEntity<String> createPagamento(@RequestBody Pagamento obj){
        try{
            this.pagamentoService.createPagamento(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                    buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception ex){
            String errorMessage = "Erro ao efetuar pagamento: " + ex.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }
}
