package com.example.SoftwareLocacao.services;

import com.example.SoftwareLocacao.repositories.CarroRepository;
import com.example.SoftwareLocacao.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public Carro findCarroById(Long id){
        Optional<carro> filial = this.carroRepository.findById(id);
        return carro.orElseThrow( () -> new ObjectNotFoundException(
                "Carro não encontrado! id: " + id + ", Tipo: " + Carro.class.getMarca()
        ));
    }


}
