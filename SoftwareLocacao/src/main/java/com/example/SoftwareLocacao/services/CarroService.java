package com.example.SoftwareLocacao.services;

import com.example.SoftwareLocacao.models.Carro;
import com.example.SoftwareLocacao.repositories.CarroRepository;
import com.example.SoftwareLocacao.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public Carro findCarroById(Long id){
        Optional<Carro> carro = this.carroRepository.findById(id);
        return carro.orElseThrow( () -> new ObjectNotFoundException(
                "Carro não encontrado! id: " + id + ", Tipo: " + Carro.class.getName()
        ));
    }

    @Transactional
    public Carro createCarro(Carro obj){
        obj.setId(null);
        obj.setStatusCarro(0);
        obj = this.carroRepository.save(obj);
        return obj;
    }
    @Transactional
    public Carro updateCarro(Carro obj) {
        Carro newObj = findCarroById(obj.getId());
        newObj.setMarca(obj.getMarca());
        newObj.setAno(obj.getAno());
        newObj.setCor(obj.getCor());
        newObj.setModelo(obj.getModelo());
        newObj.setTipoCombustivel(obj.getTipoCombustivel());
        newObj.setStatusCarro(obj.getStatusCarro());
        newObj.setQuilometragem(obj.getQuilometragem());
        newObj.setPlaca(obj.getPlaca());
        return this.carroRepository.save(newObj);
    }

    public void deleteCarro(Long id){
        findCarroById(id);
        try {
            this.carroRepository.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }


}
