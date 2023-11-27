package com.example.SoftwareLocacao.security;

import com.example.SoftwareLocacao.models.ProfileEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

public class AdminSpringSecurity {
    @NoArgsConstructor
    @Getter
        private Long id;
        private String nome;
        private String senha;
        private String email;
        private String cpf;
        private String dtNascimento;
        private String cnpj;

        private Collection<? extends GrantedAuthority> autorizado;

        public AdminSpringSecurity(Long id, String nome, String senha, String email, String cpf, String dtNascimento, String cnpj) {
            this.id = id;
            this.nome = nome;
            this.senha = senha;
            this.email = email;
            this.cpf = cpf;
            this.dtNascimento = dtNascimento;
            this.cnpj = cnpj;
            this.autorizado = profileEnums.stream().map(x -> new SimpleGrantedAuthority(x.getDescription()))
                    .collect(Collectors.toList());
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        public boolean hasRole(ProfileEnum profileEnum) {
            return getAuthorities().contains(new SimpleGrantedAuthority(profileEnum.getDescription()));
        }

}

