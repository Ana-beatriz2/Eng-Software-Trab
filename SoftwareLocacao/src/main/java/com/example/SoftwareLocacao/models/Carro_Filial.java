package com.example.SoftwareLocacao.models;

import jakarta.persistence.*;
import com.example.SoftwareLocacao.models.Carro_Filial_Id;

@Entity
@Table(name = Carro_Filial.TABLE_NAME)
public class Carro_Filial {
    public static final String TABLE_NAME = "carro_filial";

    @EmbeddedId
    private Carro_Filial_Id id;

    public Carro_Filial(){

    }

    public Carro_Filial(Carro_Filial_Id id) {
        this.id = id;
    }
}
