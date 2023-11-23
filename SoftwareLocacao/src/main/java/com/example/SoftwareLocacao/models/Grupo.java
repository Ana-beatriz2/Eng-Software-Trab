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

    @Column(name = "classificação", nullable = false, unique = true)
    private String classificação;

    @Column(name = "valorGrupo", nullable = false)
    private float valorGrupo;

    public Grupo() {
    }
    public Grupo(Long id, String classificação, float valorGrupo) {
        this.id = id;
        this.classificação = classificação;
        this.valorGrupo = valorGrupo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassificação() {
        return classificação;
    }

    public void setClassificação(String classificação) {
        this.classificação = classificação;
    }

    public float getValorGrupo() {
        return valorGrupo;
    }

    public void setValorGrupo(float valorGrupo) {
        this.valorGrupo = valorGrupo;
    }
}
