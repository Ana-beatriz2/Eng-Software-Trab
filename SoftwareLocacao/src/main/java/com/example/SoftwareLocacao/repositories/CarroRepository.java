package com.example.SoftwareLocacao.repositories;

import com.example.SoftwareLocacao.models.Carro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
