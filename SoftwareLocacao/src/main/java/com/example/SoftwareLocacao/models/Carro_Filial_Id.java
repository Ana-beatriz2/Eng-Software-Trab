package com.example.SoftwareLocacao.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;


@Embeddable
public class Carro_Filial_Id implements Serializable {
    private Long carro;

    private Long filial;

    public Carro_Filial_Id() {
    }

    public Carro_Filial_Id(Long carro, Long filial) {
        this.carro = carro;
        this.filial = filial;
    }
}
