package com.example.SoftwareLocacao.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = UsuarioAdministrador.TABLE_NAME)
public class UsuarioAdministrador {
    public static final String TABLE_NAME = "usuarioAdministrador";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // estratégia para gerar o numero no bd. Como o Autoincrements
    @Column(name = "id", unique = true) // não precisava por o id aqui também, foi feito só por precaução
    private Long id;

    @Column(name = "nome", length = 100, nullable = false, unique = true)
    private String nome;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "senha", length = 60, nullable = false)
    private String senha;

    @Column(name = "cpf", nullable = true, unique = true)
    private String cpf;

    @Column(name = "datNascimento", length = 50, nullable = false)
    private String dtNascimento;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "cnpj", nullable = true, unique = true)
    private String cnpj; //se não tiver, é pessoa física

    @Column(name = "ctps", nullable = false, unique = true)
    private String ctps;

    @Column(name = "statusGerente", nullable = false)
    private int statusGerente;

    public UsuarioAdministrador() {
    }
    public UsuarioAdministrador(Long id, String nome, String email, String senha, String cpf, String dtNascimento, String endereco, String cnpj, String ctps, int statusGerente) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.ctps = ctps;
        this.statusGerente = statusGerente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public int getStatusGerente() {
        return statusGerente;
    }

    public void setStatusGerente(int statusGerente) {
        this.statusGerente = statusGerente;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UsuarioAdministrador that = (UsuarioAdministrador) obj;
        return statusGerente == that.statusGerente && Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(email, that.email) && Objects.equals(senha, that.senha) && Objects.equals(cpf, that.cpf) && Objects.equals(dtNascimento, that.dtNascimento) && Objects.equals(endereco, that.endereco) && Objects.equals(cnpj, that.cnpj) && Objects.equals(ctps, that.ctps);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }
}
