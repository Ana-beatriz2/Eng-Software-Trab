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

    @Column(name = "dataHoraDevolucao")
    private String dataHoraDevolucao;

    @Column(name = "dataHoraRetirada")
    private String dataHoraRetirada;

    @OneToOne
    @JoinColumn(name = "motoristaId", nullable = true, unique = true)
    private Motorista motorista;

    @ManyToOne
    @JoinColumn(name = "usuarioId", nullable = false)
    private UsuarioCliente usuario;

    @ManyToOne
    @JoinColumn(name = "grupoId", nullable = false)
    private Grupo grupoReservado;

    @ManyToOne
    @JoinColumn(name = "filialEntrega", nullable = false)
    private Filial filialDeEntrega;

    @ManyToOne
    @JoinColumn(name = "filialRetirada", nullable = false)
    private Filial filialDeRetirada;

    @ManyToOne
    @JoinColumn(name = "filialRetirada", nullable = true)
    private Filial filialEntregaReal;

    public Locacao() {
    }

    public Locacao(Long id, String dataHoraDevolucao, String dataHoraRetirada, Filial filialEntregaReal, UsuarioCliente usuario, Motorista motorista, Grupo grupoReservado,
                   Filial filialDeEntrega, Filial filialDeRetirada) {
        this.id = id;
        this.dataHoraDevolucao = dataHoraDevolucao;
        this.dataHoraRetirada = dataHoraRetirada;
        this.filialEntregaReal = filialEntregaReal;
        this.usuario = usuario;
        this.motorista = motorista;
        this.grupoReservado = grupoReservado;
        this.filialDeEntrega = filialDeEntrega;
        this.filialDeRetirada = filialDeRetirada;
    }
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDataHoraDevolucao() { return dataHoraDevolucao; }

    public void setDataHoraDevolucao(String dataHoraDevolucao) { this.dataHoraDevolucao = dataHoraDevolucao;}

    public String getDataHoraRetirada() { return dataHoraRetirada; }

    public void setDataHoraRetirada(String dataHoraRetirada) { this.dataHoraRetirada = dataHoraRetirada; }

    public Filial getFilialEntregaReal() {
        return filialEntregaReal;
    }

    public void setFilialEntregaReal(Filial filialEntregaReal) {
        this.filialEntregaReal = filialEntregaReal;
    }

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

    public Grupo getGrupoReservado() {
        return grupoReservado;
    }

    public void setGrupoReservado(Grupo carroReservado) {
        this.grupoReservado = grupoReservado;
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
