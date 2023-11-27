package com.example.SoftwareLocacao.services;

import com.example.SoftwareLocacao.models.UsuarioAdministrador;
import com.example.SoftwareLocacao.repositories.UsuarioAdministradorRepository;
import com.example.SoftwareLocacao.services.exceptions.DataIntegrityViolationException;
import com.example.SoftwareLocacao.services.exceptions.ObjectNotFoundException;
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
        return usuarioAdministrador.orElseThrow( () -> new ObjectNotFoundException(
           "Usuário não encontrado! id: " + id + ", Tipo: " + UsuarioAdministrador.class.getName()
        ));
    }

    @Transactional //usa quando vai salvar algo no banco
    public UsuarioAdministrador create(UsuarioAdministrador obj){
        UsuarioAdministrador usuarioNome = this.usuarioAdmRepository.findByNome(obj.getNome());
        UsuarioAdministrador usuarioEmail = this.usuarioAdmRepository.findByEmail(obj.getEmail());

        if (usuarioNome != null){
            throw new DataIntegrityViolationException("Já existe um administrador com esse nome!");
        }

        if (usuarioEmail != null){
            throw new DataIntegrityViolationException("Já existe um administrador com esse email!");
        }

        if (obj.getCpf() != null){
            UsuarioAdministrador usuarioCpf = this.usuarioAdmRepository.findByCpf(obj.getCpf());

            if (usuarioCpf != null){
                throw new DataIntegrityViolationException("Já existe um usuário com esse Cpf!");
            }
        }

        if (obj.getCnpj() != null){
            UsuarioAdministrador usuarioCpnj = this.usuarioAdmRepository.findByCnpj(obj.getCnpj());

            if (usuarioCpnj != null){
                throw new DataIntegrityViolationException("Já existe um usuário com esse Cnpj!");
            }
        }


        if (obj.getNome() == null || obj.getEmail() == null || obj.getEndereco() == null || obj.getSenha() == null ||
               obj.getDtNascimento() == null || (obj.getCpf() == null && obj.getCnpj() == null)){
            throw new DataIntegrityViolationException("Campos obrigatórios não foram preenchidos!");
        }

        if (obj.getCpf() != null && obj.getCnpj() != null){
            throw new DataIntegrityViolationException("Deve ser escolhido o campo de cpf (pessoa física) ou cnpj " +
                    "(pessoa jurídica) para ser preenchido.");
        }

        obj.setId(null);
        obj = this.usuarioAdmRepository.save(obj);
        return obj;
    }
    @Transactional
     public UsuarioAdministrador update(UsuarioAdministrador obj) {

        UsuarioAdministrador usuarioNome = this.usuarioAdmRepository.findByNome(obj.getNome());
        UsuarioAdministrador usuarioEmail = this.usuarioAdmRepository.findByEmail(obj.getEmail());

        if (usuarioNome != null){
            throw new DataIntegrityViolationException("Já existe um usuário com esse nome!");
        }

        if (usuarioEmail != null){
            throw new DataIntegrityViolationException("Já existe um usuário com esse email!");
        }

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
