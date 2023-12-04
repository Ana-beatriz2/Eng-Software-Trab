package com.example.SoftwareLocacao.services;

import com.example.SoftwareLocacao.models.Filial;
import com.example.SoftwareLocacao.repositories.FilialRepository;
import com.example.SoftwareLocacao.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FilialService {
    @Autowired
    private FilialRepository filialRepository;

    public Filial findFilialById(Long id){
        Optional<Filial> filial = this.filialRepository.findById(id);
        return filial.orElseThrow( () -> new ObjectNotFoundException(
                "Filial não encontrada! id: " + id + ", Tipo: " + Filial.class.getName()
        ));
    }

    @Transactional
    public Filial createFilial(Filial obj){
        obj.setId(null);
        obj = this.filialRepository.save(obj);
        return obj;
    }

    public void deleteFilial(Long id){
        findFilialById(id);
        try {
            this.filialRepository.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }

}
