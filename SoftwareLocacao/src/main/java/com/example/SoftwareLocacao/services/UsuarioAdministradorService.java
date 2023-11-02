package com.example.SoftwareLocacao.services;

import com.example.SoftwareLocacao.models.UsuarioAdministrador;
import com.example.SoftwareLocacao.repositories.UsuarioAdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioAdministradorService {

    @Autowired
    private UsuarioAdministradorRepository usuarioAdmRepository;

    @Transactional //usa quando vai salvar algo no banco
    public UsuarioAdministrador create(UsuarioAdministrador obj){
        obj.setId(null);
        obj = this.usuarioAdmRepository.save(obj);
        return obj;
    }
}
