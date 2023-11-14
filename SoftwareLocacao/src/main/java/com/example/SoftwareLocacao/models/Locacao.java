package com.example.SoftwareLocacao.models;

import jakarta.persistence.*;
import com.example.SoftwareLocacao.models.UsuarioCliente;
import com.example.SoftwareLocacao.models.Motorista;

@Entity
@Table(name = Locacao.TABLE_NAME)
public class Locacao {
    public static final String TABLE_NAME = "Locacao";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "dataHoraDevolucao")
    private String dataHoraDevolucao;

    @Column(name = "dataHoraRetirada")
    private String dataHoraRetirada;

    @Column(name = "retirada", length = 100, nullable = false, unique = true) //filial retirada (real)
    private String retirada;

    @Column(name = "carro", nullable = false, unique = true)
    private String carro;

    @OneToOne
    @JoinColumn(nullable = true, unique = true)
    private Motorista motorista;

    @ManyToOne
    @JoinColumn(nullable = false) //unique = false (é o padrão)
    private UsuarioCliente usuario;

    public Locacao() {
    }

    public Locacao(Long id, String dataHoraDevolucao, String dataHoraRetirada, String retirada, String carro, Motorista motorista, UsuarioCliente usuario) {
        this.id = id;
        this.dataHoraDevolucao = dataHoraDevolucao;
        this.dataHoraRetirada = dataHoraRetirada;
        this.retirada = retirada;
        this.carro = carro;
        this.motorista = motorista;
        this.usuario = usuario;
    }
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDataHoraDevolucao() { return dataHoraDevolucao; }

    public void setDataHoraDevolucao(String dataHoraDevolucao) { this.dataHoraDevolucao = dataHoraDevolucao;}

    public String getDataHoraRetirada() { return dataHoraRetirada; }

    public void setDataHoraRetirada(String dataHoraRetirada) { this.dataHoraRetirada = dataHoraRetirada; }

    public String getRetirada() { return retirada; }

    public void setRetirada(String retirada) { this.retirada = retirada; }

    public String getCarro() { return carro; }

    public void setCarro(String carro) { this.carro = carro; }

    public Motorista getMotorista() {
        return motorista;
    }
    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public UsuarioCliente getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioCliente usuario) {
        this.usuario = usuario;
    }
}
