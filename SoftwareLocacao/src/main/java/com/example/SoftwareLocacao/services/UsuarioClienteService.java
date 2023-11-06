package com.example.SoftwareLocacao.services;

import com.example.SoftwareLocacao.models.UsuarioCliente;
import com.example.SoftwareLocacao.repositories.UsuarioClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioClienteService {

    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;

    public UsuarioCliente findById(Long id){
        Optional<UsuarioCliente> usuarioCliente = this.usuarioClienteRepository.findById(id);
        return usuarioCliente.orElseThrow( () -> new RuntimeException(
                "Usuário não encontrado! id: " + id + ", Tipo: " + UsuarioCliente.class.getName()
        ));
    }

    public UsuarioCliente findClienteByName(String name){
        Optional<UsuarioCliente> usuarioCliente = Optional.ofNullable(this.usuarioClienteRepository.findByNome(name));
        return usuarioCliente.orElseThrow( () -> new RuntimeException(
                "Usuário não encontrado! Nome: " + name + ", Tipo: " + UsuarioCliente.class.getName()
        ));
    }

    @Transactional //usa quando vai salvar algo no banco
    public UsuarioCliente create(UsuarioCliente obj){
        obj.setId(null);
        obj.setPontosProgFidelidade(0);
        obj = this.usuarioClienteRepository.save(obj);
        return obj;
    }
    @Transactional
    public UsuarioCliente update(UsuarioCliente obj) {
        UsuarioCliente newObj = findById(obj.getId());
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
        newObj.setSenha(obj.getSenha());
        newObj.setCpf(obj.getCpf());
        newObj.setDtNascimento(obj.getDtNascimento());
        newObj.setEndereco(obj.getEndereco());
        newObj.setCnpj(obj.getCnpj());
        newObj.setPontosProgFidelidade(obj.getPontosProgFidelidade());
        newObj.setStatusMotorista(obj.getStatusMotorista());
        return this.usuarioClienteRepository.save(newObj);
    }

    public void delete(Long id){
        findById(id);
        try {
            this.usuarioClienteRepository.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }

}
