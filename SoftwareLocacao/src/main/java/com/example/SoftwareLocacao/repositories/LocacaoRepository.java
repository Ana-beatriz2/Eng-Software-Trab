package com.example.SoftwareLocacao.repositories;

import com.example.SoftwareLocacao.models.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
    List<Locacao> findAll();
}
