package com.example.SoftwareLocacao.models;

import jakarta.persistence.*;

@Entity
@Table(name = Locacao.TABLE_NAME)
public class Locacao {
    public static final String TABLE_NAME = "Locacao";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "dataHoraDevolucao", nullable = false)
    private String dataHoraDevolucao;

    @Column(name = "dataHoraRetirada", nullable = false)
    private String dataHoraRetirada;

    @Column(name = "retirada", length = 100, nullable = true) //filial retirada (real)
    private String retirada;

    @OneToOne
    @JoinColumn(name = "motoristaId", nullable = true)
    private Motorista motorista;

    @ManyToOne
    @JoinColumn(name = "usuarioId", nullable = false)
    private UsuarioCliente usuario;

    @ManyToOne
    @JoinColumn(name = "carroId", nullable = false)
    private Carro carroReservado;

    @ManyToOne
    @JoinColumn(name = "filialEntrega", nullable = false)
    private Filial filialDeEntrega;

    @ManyToOne
    @JoinColumn(name = "filialRetirada", nullable = false)
    private Filial filialDeRetirada;

    public Locacao() {
    }

    public Locacao(Long id, String dataHoraDevolucao, String dataHoraRetirada, String retirada, UsuarioCliente usuario, Motorista motorista, Carro carroReservado,
                   Filial filialDeEntrega, Filial filialDeRetirada) {
        this.id = id;
        this.dataHoraDevolucao = dataHoraDevolucao;
        this.dataHoraRetirada = dataHoraRetirada;
        this.retirada = retirada;
        this.usuario = usuario;
        this.motorista = motorista;
        this.carroReservado = carroReservado;
        this.filialDeEntrega = filialDeEntrega;
        this.filialDeRetirada = filialDeRetirada;
    }
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDataHoraDevolucao() { return dataHoraDevolucao; }

    public void setDataHoraDevolucao(String dataHoraDevolucao) { this.dataHoraDevolucao = dataHoraDevolucao;}

    public String getDataHoraRetirada() { return dataHoraRetirada; }

    public void setDataHoraRetirada(String dataHoraRetirada) { this.dataHoraRetirada = dataHoraRetirada; }

    public String getRetirada() { return retirada; }

    public void setRetirada(String retirada) { this.retirada = retirada; }
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

    public Carro getCarroReservado() {
        return carroReservado;
    }

    public void setCarroReservado(Carro carroReservado) {
        this.carroReservado = carroReservado;
    }

    public Filial getFilialDeEntrega() {
        return filialDeEntrega;
    }

    public void setFilialDeEntrega(Filial filialDeEntrega) {
        this.filialDeEntrega = filialDeEntrega;
    }

    public Filial getFilialDeRetirada() {
        return filialDeRetirada;
    }

    public void setFilialDeRetirada(Filial filialDeRetirada) {
        this.filialDeRetirada = filialDeRetirada;
    }
}
