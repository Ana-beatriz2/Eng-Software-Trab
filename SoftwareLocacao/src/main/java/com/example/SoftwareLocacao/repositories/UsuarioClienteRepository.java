package com.example.SoftwareLocacao.repositories;

import com.example.SoftwareLocacao.models.UsuarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Long> {
    
    UsuarioCliente findByNome(String nome);

    UsuarioCliente findByEmail(String email);

    UsuarioCliente findByCpf(String cpf);

    UsuarioCliente findByCnpj(String cnpj);

}
