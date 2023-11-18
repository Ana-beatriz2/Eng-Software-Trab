package com.example.SoftwareLocacao.models;

import jakarta.persistence.*;

@Entity
@Table(name = Motorista.TABLE_NAME)
public class Motorista {
    public static final String TABLE_NAME = "motorista";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "cnh", nullable = true, unique = true)
    private String cnh;

    @Column(name = "nome", length = 100, nullable = false, unique = true)
    private String nome;

    @Column(name = "datNascimento", length = 50, nullable = false)
    private String dtNascimento;

    @Column(name = "cpf", nullable = true, unique = true)
    private String cpf;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "ads", nullable = false, unique = true)
    private String ads;

    public Motorista(){
    }

    public Motorista(Long id, String cnh, String nome, String dtNascimento, String cpf, String email, String ads){
        this.id = id;
        this.cnh = cnh;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.email = email;
        this.ads = ads;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getCnh() { return cnh; }

    public void setCnh(String cnh) { this.cnh = cnh; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getDtNascimento() { return dtNascimento; }

    public void setDtNascimento(String dtNascimento) { this.dtNascimento = dtNascimento; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getAds() { return ads; }

    public void setAds(String ads) { this.ads = ads; }

}