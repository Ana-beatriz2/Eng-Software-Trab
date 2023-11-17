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

    @OneToOne
    @JoinColumn(name = "locacao_id", nullable = true, unique = true)
    private Locacao locacao;

    public Devolucao(){
    }

    public Devolucao(Long id, String dataHoraDevolucao, int quilometragemDevolucao, String estadoVeiculo, Locacao locacao){
        this.id = id;
        this.dataHoraDevolucao = dataHoraDevolucao;
        this.quilometragemDevolucao = quilometragemDevolucao;
        this.estadoVeiculo = estadoVeiculo;
        this.locacao = locacao;
    }
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDataHoraDevolucao() { return dataHoraDevolucao;}

    public void setDataHoraDevolucao(String dataHoraDevolucao) { this.dataHoraDevolucao = dataHoraDevolucao; }

    public int getQuilometragemDevolucao() { return quilometragemDevolucao; }

    public void setQuilometragemDevolucao(int quilometragemDevolucao) { this.quilometragemDevolucao = quilometragemDevolucao; }

    public String getEstadoVeiculo() { return estadoVeiculo; }

    public void setEstadoVeiculo(String estadoVeiculo) { this.estadoVeiculo = estadoVeiculo; }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }
}
