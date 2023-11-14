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

    @Column(name = "modelo", nullable = true, unique = true)
    private String modelo;

    @Column(name = "cor", nullable = true)
    private String cor;

    @Column(name = "tipoCombustivel", nullable = true)
    private String tipoCombustivel;

    @Column(name = "statusCarro", nullable = true)
    private String statusCarro;

    @Column(name = "quilometragem", nullable = true, unique = true)
    private int quilometragem;

    public Carro(){
    }

    public Carro(Long id, String marca, int ano, String placa, String Modelo, String cor, String tipoCombustivel, String statusCarro, int quilometragem){
        this.id = id;
        this.marca = marca;
        this.ano = ano;
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.tipoCombustivel = tipoCombustivel;
        this.statusCarro = statusCarro;
        this.quilometragem = quilometragem;
    }
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id;}

    public String getMarca() { return marca; }

    public void setMarca(String marca) { this.marca = marca; }

    public int getAno() { return ano; }

    public void setAno(int ano) { this.ano = ano; }

    public String getPlaca() { return placa; }

    public void setPlaca(String placa) { this.placa = placa; }

    public String getModelo() { return modelo; }

    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getCor() { return cor; }

    public void setCor(String cor) { this.cor = cor; }

    public String getTipoCombustivel() { return tipoCombustivel; }

    public void setTipoCombustivel(String tipoCombustivel) { this.tipoCombustivel = tipoCombustivel; }

    public String getStatusCarro() { return statusCarro; }

    public void setStatusCarro(String statusCarro) { this.statusCarro = statusCarro; }

    public int getQuilometragem() { return quilometragem; }

    public void setQuilometragem(int quilometragem) { this.quilometragem = quilometragem; }
}
