package com.microfinancasapi.dto;

import jakarta.validation.constraints.*;

public class GrupoRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "responsavel não pode estar em branco")
    private String responsavel;
    @NotBlank(message = "ciclo não pode estar em branco")
    private String ciclo;
    @NotNull(message = "max membros não pode ser nulo")
    private Integer maxMembros;
    @NotNull(message = "capital giro não pode ser nulo")
    private Double capitalGiro;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

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
