package com.example.SoftwareLocacao.models;

import jakarta.persistence.*;

@Entity
@Table(name = Pagamento.TABLE_NAME)
public class Pagamento {
    public static final String TABLE_NAME = "pagamento";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "valor", nullable = true)
    private int valor;

    @Column(name = "numBanco", nullable = true, unique = true)
    private int numBanco;

    @Column(name = "data", nullable = true)
    private String data;

    @Column(name = "status", nullable = true)
    private String status;

    @Column(name = "descricao",length = 200, nullable = true)
    private String descricao;

    @Column(name = "tipo", nullable = true)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "locacao_id", nullable = false)
    private Locacao locacao;

    public Pagamento(){
    }

    public Pagamento(Long id, int valor, int numBanco, String data, String status, String descricao, String tipo, Locacao locacao){
        this.id = id;
        this.valor = valor;
        this.numBanco = numBanco;
        this.data = data;
        this.status = status;
        this.descricao = descricao;
        this.tipo = tipo;
        this.locacao = locacao;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public int getValor() { return valor; }

    public void setValor(int valor) { this.valor = valor; }

    public int getNumBanco() { return numBanco; }

    public void setNumBanco(int numBanco) { this.numBanco = numBanco; }

    public String getData() { return data; }

    public void setData(String data) { this.data = data; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }
}
