package com.example.SoftwareLocacao.repositories;

import com.example.SoftwareLocacao.models.UsuarioAdministrador;
import com.example.SoftwareLocacao.models.UsuarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Long> {


}
