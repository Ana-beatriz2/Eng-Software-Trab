package com.example.SoftwareLocacao.models;

import jakarta.persistence.*;

@Entity
@Table(name = Devolucao.TABLE_NAME)
public class Devolucao{
    public static final String TABLE_NAME = "devolucao";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "dataHoraDevolucao", nullable = true)
    private String dataHoraDevolucao;

    @Column(name = "quilometragemDevolucao", nullable = true)
    private int quilometragemDevolucao;

    @Column(name = "estadoVeiculo", nullable = true)
    private String estadoVeiculo;

    public Devolucao(){
    }

    public Devolucao(Long id, String dataHoraDevolucao, int quilometragemDevolucao, String estadoVeiculo){
        this.id = id;
        this.dataHoraDevolucao = dataHoraDevolucao;
        this.quilometragemDevolucao = quilometragemDevolucao;
        this.estadoVeiculo = estadoVeiculo;
    }
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDataHoraDevolucao() { return dataHoraDevolucao;}

    public void setDataHoraDevolucao(String dataHoraDevolucao) { this.dataHoraDevolucao = dataHoraDevolucao; }

    public int getQuilometragemDevolucao() { return quilometragemDevolucao; }

    public void setQuilometragemDevolucao(int quilometragemDevolucao) { this.quilometragemDevolucao = quilometragemDevolucao; }

    public String getEstadoVeiculo() { return estadoVeiculo; }

    public void setEstadoVeiculo(String estadoVeiculo) { this.estadoVeiculo = estadoVeiculo; }

}
