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

    @Column(name = "valorTotal", nullable = false)
    private float valorTotal;

    @OneToOne
    @JoinColumn(name = "motoristaId", nullable = true)
    private Motorista motorista;

    @ManyToOne
    @JoinColumn(name = "usuarioId", nullable = false)
    private UsuarioCliente usuario;

    @ManyToOne
    @JoinColumn(name = "filialEntrega", nullable = false)
    private Filial filialDeEntrega;

    @ManyToOne
    @JoinColumn(name = "filialRetirada", nullable = false)
    private Filial filialDeRetirada;

    @ManyToOne
    @JoinColumn(name = "filialEntregaReal", nullable = true)
    private Filial filialEntregaReal;

    @ManyToOne
    @JoinColumn(name = "grupoId", nullable = false)
    private Grupo grupo;

    public Locacao() {
    }

    public Locacao(Long id, String dataHoraDevolucao, String dataHoraRetirada, Filial filialEntregaReal, UsuarioCliente usuario, Motorista motorista, Grupo grupo,
                   Filial filialDeEntrega, Filial filialDeRetirada, float valorTotal) {
        this.id = id;
        this.dataHoraDevolucao = dataHoraDevolucao;
        this.dataHoraRetirada = dataHoraRetirada;
        this.filialEntregaReal = filialEntregaReal;
        this.usuario = usuario;
        this.motorista = motorista;
        this.grupo = grupo;
        this.filialDeEntrega = filialDeEntrega;
        this.filialDeRetirada = filialDeRetirada;
        this.valorTotal = valorTotal;
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

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
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

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
