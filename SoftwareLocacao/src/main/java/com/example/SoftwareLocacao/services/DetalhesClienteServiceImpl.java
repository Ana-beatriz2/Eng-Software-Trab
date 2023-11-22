package com.example.SoftwareLocacao.services;

import com.example.SoftwareLocacao.models.UsuarioCliente;
import com.example.SoftwareLocacao.security.UserSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.SoftwareLocacao.models.UsuarioCliente;
import com.example.SoftwareLocacao.repositories.UsuarioClienteRepository;
import com.example.SoftwareLocacao.security.UserSpringSecurity;

import java.util.Objects;

public class DetalhesUsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioCliente usuarioCliente;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioCliente Cliente = this.usuarioCliente.findByUsername(username);
        if (Objects.isNull(Cliente))
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        return new UserSpringSecurity(Cliente.getId(), Cliente.getNome(), Cliente.getEmail(), Cliente.getSenha(), Cliente.getCpf(), Cliente.getDtNascimento(), Cliente.getCnpj(), Cliente.getPontosProgFidelidade());
    }

}