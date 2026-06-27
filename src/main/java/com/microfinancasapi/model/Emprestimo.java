package com.microfinancasapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;
    private Double valorSolicitado;
    private Double valorAprovado;
    private Double taxaJuros;
    private Integer parcelas;
    private java.time.LocalDateTime dataAprovacao;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Grupo getGrupo() { return grupo; }
    public void setGrupo(Grupo grupo) { this.grupo = grupo; }
    public Double getValorSolicitado() { return valorSolicitado; }
    public void setValorSolicitado(Double valorSolicitado) { this.valorSolicitado = valorSolicitado; }
    public Double getValorAprovado() { return valorAprovado; }
    public void setValorAprovado(Double valorAprovado) { this.valorAprovado = valorAprovado; }
    public Double getTaxaJuros() { return taxaJuros; }
    public void setTaxaJuros(Double taxaJuros) { this.taxaJuros = taxaJuros; }
    public Integer getParcelas() { return parcelas; }
    public void setParcelas(Integer parcelas) { this.parcelas = parcelas; }
    public java.time.LocalDateTime getDataAprovacao() { return dataAprovacao; }
    public void setDataAprovacao(java.time.LocalDateTime dataAprovacao) { this.dataAprovacao = dataAprovacao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
