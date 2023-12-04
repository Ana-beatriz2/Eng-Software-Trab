package com.example.SoftwareLocacao.repositories;

import com.example.SoftwareLocacao.models.UsuarioAdministrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioAdministradorRepository extends JpaRepository<UsuarioAdministrador, Long> {
    UsuarioAdministrador findBySenha(String senha);

    UsuarioAdministrador findByNomeAndSenha(String nomeAdmin, String senhaAdmin);

    List<UsuarioAdministradorRepository> findByNomeContains(String nome);


}
