package com.example.SoftwareLocacao.models;

import jakarta.persistence.*;

@Entity
@Table(name = Devolucao.TABLE_NAME)
public class Filial{
    public static final String TABLE_NAME = "filial";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "endereco", length = 100, nullable = false, unique = true)
    private String endereco;

    @Column(name = "cnpj", length = 20, nullable = false, unique = true)
    private String cnpj;

    @Column(name = "cep", length = 15, nullable = false, unique = true)
    private String cep;

    public Filial(){
    }

    public Filial(Long id, String endereco, String cnpj, String cep){
       this.id = id;
       this.cnpj = cnpj;
       this.cep = cep;
    }
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getEndereco() { return endereco; }

    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getCnpj() { return cnpj; }

    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getCep() { return cep; }

    public void setCep(String cep) { this.cep = cep; }

}
