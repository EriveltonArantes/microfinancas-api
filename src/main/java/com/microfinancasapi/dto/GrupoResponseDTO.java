package com.microfinancasapi.dto;

public class GrupoResponseDTO {

    private Long id;
    private String nome;
    private String responsavel;
    private String ciclo;
    private Integer maxMembros;
    private Double capitalGiro;
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
