package com.example.SoftwareLocacao.models;

import jakarta.persistence.*;

@Entity
@Table(name = Carro.TABLE_NAME)
public class Carro{
    public static final String TABLE_NAME = "carro";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "marca", nullable = true, unique = true)
    private String marca;

    @Column(name = "ano", nullable = false)
    private int ano;

    @Column(name = "placa", nullable = true, unique = true)
    private String placa;

    @Column(name = "cor", nullable = true)
    private String cor;

    @Column(name = "tipoCombustivel", nullable = true)
    private String tipoCombustivel;

    @Column(name = "statusCarro", nullable = true)
    private String statusCarro;

    @Column(name = "quilometragem", nullable = true, unique = true)
    private int quilometragem;
}
