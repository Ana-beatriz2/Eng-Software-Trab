package com.example.SoftwareLocacao.repositories;

import com.example.SoftwareLocacao.models.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
