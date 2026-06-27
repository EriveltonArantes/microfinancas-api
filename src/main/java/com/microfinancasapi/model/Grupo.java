package com.microfinancasapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "grupos")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String responsavel;
    @Column(nullable = false)
    private String ciclo;
    private Integer maxMembros;
    private Double capitalGiro;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
    public String getCiclo() { return ciclo; }
    public void setCiclo(String ciclo) { this.ciclo = ciclo; }
    public Integer getMaxMembros() { return maxMembros; }
    public void setMaxMembros(Integer maxMembros) { this.maxMembros = maxMembros; }
    public Double getCapitalGiro() { return capitalGiro; }
    public void setCapitalGiro(Double capitalGiro) { this.capitalGiro = capitalGiro; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
