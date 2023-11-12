package com.example.SoftwareLocacao.models;

import jakarta.persistence.*;

@Entity
@Table(name = Locacao.TABLE_NAME)
public class Locacao {
    public static final String TABLE_NAME = "Locacao";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "dataHoraDevolucao")
    private int dataHoraDevolucao;

    @Column(name = "dataHoraRetirada")
    private int dataHoraRetirada;

    @Column(name = "retirada", length = 100, nullable = false, unique = true)
    private String retirada;

    @Column(name = "carro", nullable = false, unique = true)
    private String carro;

    public Locacao() {
    }

    public Locacao(Long id, int dataHoraDevolucao, int dataHoraRetirada, String retirada, String carro) {
        this.id = id;
        this.dataHoraDevolucao = dataHoraDevolucao;
        this.dataHoraRetirada = dataHoraRetirada;
        this.retirada = retirada;
        this.carro = carro;
    }
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public int getDataHoraDevolucao() { return dataHoraDevolucao; }

    public void setDataHoraDevolucao(int dataHoraDevolucao) { this.dataHoraDevolucao = dataHoraDevolucao;}

    public int getDataHoraRetirada() { return dataHoraRetirada; }

    public void setDataHoraRetirada(int dataHoraRetirada) { this.dataHoraRetirada = dataHoraRetirada; }

    public String getRetirada() { return retirada; }

    public void setRetirada(String retirada) { this.retirada = retirada; }

    public String getCarro() { return carro; }

    public void setCarro(String carro) { this.carro = carro; }

}
