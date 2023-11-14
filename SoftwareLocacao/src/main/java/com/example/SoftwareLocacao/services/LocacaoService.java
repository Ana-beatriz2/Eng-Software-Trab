package com.example.SoftwareLocacao.services;


import com.example.SoftwareLocacao.models.Locacao;
import com.example.SoftwareLocacao.models.UsuarioAdministrador;
import com.example.SoftwareLocacao.repositories.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    public Locacao findLocacaoById(Long id){
        Optional<Locacao> locacao = this.locacaoRepository.findById(id);
        return locacao.orElseThrow( () -> new RuntimeException(
                "Usuário não encontrado! id: " + id + ", Tipo: " + Locacao.class.getName()
        ));
    }

    @Transactional
    public Locacao createLocacao(Locacao obj){
        obj.setId(null);
        obj = this.locacaoRepository.save(obj);
        return obj;
    }
    @Transactional
    public Locacao updateLocacao(Locacao obj) {
        Locacao newObj = findLocacaoById(obj.getId());
        obj.setDataHoraDevolucao(newObj.getDataHoraDevolucao());
        newObj.setDataHoraRetirada(obj.getDataHoraRetirada());
        newObj.setRetirada(obj.getRetirada());
        newObj.setCarro(obj.getCarro());
        return this.locacaoRepository.save(newObj);
    }

    public void deleteLocacao(Long id){
        findLocacaoById(id);
        try {
            this.locacaoRepository.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
