package com.example.SoftwareLocacao.services;

import com.example.SoftwareLocacao.models.UsuarioAdministrador;
import com.example.SoftwareLocacao.repositories.UsuarioAdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioAdministradorService {

    @Autowired
    private UsuarioAdministradorRepository usuarioAdmRepository;

    public UsuarioAdministrador findById(Long id){
        Optional<UsuarioAdministrador> usuarioAdministrador = this.usuarioAdmRepository.findById(id);
        return usuarioAdministrador.orElseThrow( () -> new RuntimeException(
           "Usuário não encontrado! id: " + id + ", Tipo: " + UsuarioAdministrador.class.getName()
        ));
    }

    @Transactional //usa quando vai salvar algo no banco
    public UsuarioAdministrador create(UsuarioAdministrador obj){
        obj.setId(null);
        obj = this.usuarioAdmRepository.save(obj);
        return obj;
    }
    @Transactional
     public UsuarioAdministrador update(UsuarioAdministrador obj) {
        UsuarioAdministrador newObj = findById(obj.getId());
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
        newObj.setSenha(obj.getSenha());
        newObj.setCpf(obj.getCpf());
        newObj.setDtNascimento(obj.getDtNascimento());
        newObj.setCnpj(obj.getCnpj());
        newObj.setCtps(obj.getCtps());
        return this.usuarioAdmRepository.save(newObj);
    }

    public void delete(Long id){
        findById(id);
        try {
            this.usuarioAdmRepository.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }

}
