package com.example.SoftwareLocacao.services;

import com.example.SoftwareLocacao.models.UsuarioAdministrador;
import com.example.SoftwareLocacao.security.AdminSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

public class DetalhesAdminService implements UserDetailsService {

    @Autowired
    private UsuarioAdministrador usuarioAdmin;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioAdministrador Admin = this.usuarioAdmin.findByUsername(username);
        if (Objects.isNull(Admin))
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        return new AdminSpringSecurity(Admin.getId(), Admin.getNome(), Admin.getEmail(), Admin.getSenha(), Admin.getCpf(), Admin.getDtNascimento(), Admin.getCnpj());
    }

}