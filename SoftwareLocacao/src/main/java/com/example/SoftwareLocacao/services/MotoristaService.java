package com.example.SoftwareLocacao.services;

import com.example.SoftwareLocacao.models.Motorista;
import com.example.SoftwareLocacao.repositories.MotoristaRepository;
import com.example.SoftwareLocacao.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public Motorista findMotoristaById(Long id){
        Optional<Motorista> motorista = this.motoristaRepository.findById(id);
        return motorista.orElseThrow( () -> new ObjectNotFoundException(
                "Motorista não encontrado! id: " + id + ", Tipo: " + Motorista.class.getName()
        ));
    }

    @Transactional
    public Motorista createMotorista(Motorista obj){
        obj.setId(null);
        obj = this.motoristaRepository.save(obj);
        return obj;
    }
    @Transactional
    public Motorista updateMotorista(Motorista obj) {
        Motorista newObj = findMotoristaById(obj.getId());
        newObj.setNome(obj.getNome());
        newObj.setCnh(obj.getCnh());
        newObj.setDtNascimento(obj.getDtNascimento());
        newObj.setCpf(obj.getCpf());
        newObj.setEmail(obj.getEmail());
        newObj.setAds(obj.getAds());
        return this.motoristaRepository.save(newObj);
    }

    public void deleteMotorista(Long id){
        findMotoristaById(id);
        try {
            this.motoristaRepository.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
