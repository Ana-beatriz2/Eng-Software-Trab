package com.example.SoftwareLocacao.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import com.example.SoftwareLocacao.models.Locacao;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

@Entity
@Table(name = UsuarioCliente.TABLE_NAME)
public class UsuarioCliente {
    public static final String TABLE_NAME = "usuarioCliente";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
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

    @Column(name = "pontosProgFidelidade")
    private int pontosProgFidelidade;

    @OneToMany(mappedBy = "usuario")
    private List<Locacao> locacoes = new ArrayList<Locacao>();

    public UsuarioCliente() {
    }
    public UsuarioCliente(Long id, String nome, String email, String senha, String cpf, String dtNascimento, String endereco, String cnpj, int pontosProgFidelidade, int statusMotorista) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.pontosProgFidelidade = pontosProgFidelidade;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    public int getPontosProgFidelidade() {
        return pontosProgFidelidade;
    }

    public void setPontosProgFidelidade(int pontosProgFidelidade) {
        this.pontosProgFidelidade = pontosProgFidelidade;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioCliente that = (UsuarioCliente) o;
        return pontosProgFidelidade == that.pontosProgFidelidade && Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(email, that.email) && Objects.equals(senha, that.senha) && Objects.equals(cpf, that.cpf) && Objects.equals(dtNascimento, that.dtNascimento) && Objects.equals(endereco, that.endereco) && Objects.equals(cnpj, that.cnpj);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }
}
