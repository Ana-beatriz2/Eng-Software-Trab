package com.example.SoftwareLocacao.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = Usuario.TABLE_NAME)
public class Usuario {
    public static final String TABLE_NAME = "usuario";

    @Id
    private Long id;
}
