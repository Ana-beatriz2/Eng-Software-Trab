package com.example.SoftwareLocacao.services;

import com.example.SoftwareLocacao.models.Pagamento;
import com.example.SoftwareLocacao.repositories.PagamentoRepository;
import com.example.SoftwareLocacao.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento findPagamentoById(Long id){
        Optional<Pagamento> motorista = this.pagamentoRepository.findById(id);
        return motorista.orElseThrow( () -> new ObjectNotFoundException(
                "Motorista não encontrado! id: " + id + ", Tipo: " + Pagamento.class.getName()
        ));
    }

    @Transactional
    public Pagamento createPagamento(Pagamento obj){
        // em data colocar o dia atual
        obj.setId(null);
        obj = this.pagamentoRepository.save(obj);
        return obj;
    }
}
