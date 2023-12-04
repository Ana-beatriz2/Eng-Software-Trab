package com.example.SoftwareLocacao.repositories;

import com.example.SoftwareLocacao.models.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    Motorista findByNome(String nome);

    Motorista findByEmail(String email);

    Motorista findByCpf(String cpf);

    Motorista findByAds(String ads);

    Motorista findByCnh(String cnh);

}
