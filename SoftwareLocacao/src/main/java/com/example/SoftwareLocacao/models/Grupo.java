package com.example.SoftwareLocacao.models;

import jakarta.persistence.*;

@Entity
@Table(name = Grupo.TABLE_NAME)
public class Grupo {
    public static final String TABLE_NAME = "grupo";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "classificacao", nullable = false, unique = true)
    private String classificacao;

    @Column(name = "valorGrupo", nullable = false)
    private float valorGrupo;

    public Grupo() {
    }
    public Grupo(Long id, String classificacao, float valorGrupo) {
        this.id = id;
        this.classificacao = classificacao;
        this.valorGrupo = valorGrupo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacaoo) {
        this.classificacao = classificacao;
    }

    public float getValorGrupo() {
        return valorGrupo;
    }

    public void setValorGrupo(float valorGrupo) {
        this.valorGrupo = valorGrupo;
    }
}
