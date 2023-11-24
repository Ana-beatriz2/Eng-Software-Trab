package com.example.SoftwareLocacao.services;

import com.example.SoftwareLocacao.models.UsuarioCliente;
import com.example.SoftwareLocacao.repositories.UsuarioClienteRepository;
import com.example.SoftwareLocacao.services.exceptions.DataIntegrityViolationException;
import com.example.SoftwareLocacao.services.exceptions.ObjectNotFoundException;
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
        return usuarioCliente.orElseThrow( () -> new ObjectNotFoundException(
                "Usuário não encontrado! id: " + id + ", Tipo: " + UsuarioCliente.class.getName()
        ));
    }

    public UsuarioCliente findClienteByName(String name){
        Optional<UsuarioCliente> usuarioCliente = Optional.ofNullable(this.usuarioClienteRepository.findByNome(name));
        return usuarioCliente.orElseThrow( () -> new ObjectNotFoundException(
                "Usuário não encontrado! Nome: " + name + ", Tipo: " + UsuarioCliente.class.getName()
        ));
    }

    @Transactional //usa quando vai salvar algo no banco
    public UsuarioCliente create(UsuarioCliente obj){

        UsuarioCliente usuarioNome = this.usuarioClienteRepository.findByNome(obj.getNome());
        UsuarioCliente usuarioEmail = this.usuarioClienteRepository.findByEmail(obj.getEmail());

        if (usuarioNome != null){
            throw new DataIntegrityViolationException("Já existe um usuário com esse nome!");
        }

        if (usuarioEmail != null){
            throw new DataIntegrityViolationException("Já existe um usuário com esse email!");
        }

        if (obj.getCpf() != null){
            UsuarioCliente usuarioCpf = this.usuarioClienteRepository.findByCpf(obj.getCpf());

            if (usuarioCpf != null){
                throw new DataIntegrityViolationException("Já existe um usuário com esse Cpf!");
            }
        }

        if (obj.getCnpj() != null){
            UsuarioCliente usuarioCpnj = this.usuarioClienteRepository.findByCnpj(obj.getCnpj());

            if (usuarioCpnj != null){
                throw new DataIntegrityViolationException("Já existe um usuário com esse Cnpj!");
            }
        }


        if (obj.getNome() == null || obj.getEmail() == null || obj.getEndereco() == null || obj.getSenha() == null ||
                (obj.getCpf() == null && obj.getCnpj() == null)){
            throw new DataIntegrityViolationException("Campos obrigatórios não foram preenchidos!");
        }

        if (obj.getCpf() != null && obj.getCnpj() != null){
            throw new DataIntegrityViolationException("Deve ser escolhido o campo de cpf (pessoa física) ou cnpj (pessoa jurídica) para ser preenchido.");
        }

        obj.setId(null);
        obj.setPontosProgFidelidade(0);
        obj = this.usuarioClienteRepository.save(obj);
        return obj;
    }
    @Transactional
    public UsuarioCliente update(UsuarioCliente obj) {

        UsuarioCliente usuarioNome = this.usuarioClienteRepository.findByNome(obj.getNome());
        UsuarioCliente usuarioEmail = this.usuarioClienteRepository.findByEmail(obj.getEmail());

        if (usuarioNome != null){
            throw new DataIntegrityViolationException("Já existe um usuário com esse nome!");
        }

        if (usuarioEmail != null){
            throw new DataIntegrityViolationException("Já existe um usuário com esse email!");
        }

        UsuarioCliente newObj = findById(obj.getId());
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
        newObj.setSenha(obj.getSenha());
        newObj.setCpf(obj.getCpf());
        newObj.setDtNascimento(obj.getDtNascimento());
        newObj.setEndereco(obj.getEndereco());
        newObj.setCnpj(obj.getCnpj());
        newObj.setPontosProgFidelidade(obj.getPontosProgFidelidade());
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
