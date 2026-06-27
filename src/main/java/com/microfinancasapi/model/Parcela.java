package com.microfinancasapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "parcelas")
public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "emprestimo_id")
    private Emprestimo emprestimo;
    private Integer numero;
    private java.time.LocalDateTime dataVencimento;
    private Double valorParcela;
    private Double valorPago;
    private java.time.LocalDateTime dataPagamento;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Emprestimo getEmprestimo() { return emprestimo; }
    public void setEmprestimo(Emprestimo emprestimo) { this.emprestimo = emprestimo; }
    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }
    public java.time.LocalDateTime getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(java.time.LocalDateTime dataVencimento) { this.dataVencimento = dataVencimento; }
    public Double getValorParcela() { return valorParcela; }
    public void setValorParcela(Double valorParcela) { this.valorParcela = valorParcela; }
    public Double getValorPago() { return valorPago; }
    public void setValorPago(Double valorPago) { this.valorPago = valorPago; }
    public java.time.LocalDateTime getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(java.time.LocalDateTime dataPagamento) { this.dataPagamento = dataPagamento; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
