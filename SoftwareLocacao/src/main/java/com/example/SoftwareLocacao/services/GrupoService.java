package com.example.SoftwareLocacao.services;

import com.example.SoftwareLocacao.models.Grupo;
import com.example.SoftwareLocacao.repositories.GrupoRepository;
import com.example.SoftwareLocacao.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public Grupo findGrupoById(Long id){
        Optional<Grupo> grupo = this.grupoRepository.findById(id);
        return grupo.orElseThrow( () -> new ObjectNotFoundException(
                "Grupo não encontrado! id: " + id + ", Tipo: " + Grupo.class.getName()
        ));
    }
}
