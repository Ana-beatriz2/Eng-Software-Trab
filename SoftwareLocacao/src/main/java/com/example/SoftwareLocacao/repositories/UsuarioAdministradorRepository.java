package com.example.SoftwareLocacao.repositories;

import com.example.SoftwareLocacao.models.UsuarioAdministrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioAdministradorRepository extends JpaRepository<UsuarioAdministrador, Long> {


}