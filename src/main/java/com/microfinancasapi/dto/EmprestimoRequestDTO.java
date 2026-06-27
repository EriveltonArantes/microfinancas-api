package com.microfinancasapi.dto;

import jakarta.validation.constraints.*;

public class EmprestimoRequestDTO {

    @NotNull(message = "ClienteId é obrigatório")
    @Positive(message = "ClienteId deve ser um ID válido (positivo)")
    private Long clienteId;
    @NotNull(message = "GrupoId é obrigatório")
    @Positive(message = "GrupoId deve ser um ID válido (positivo)")
    private Long grupoId;
    @DecimalMin(value = "0.0", message = "valor solicitado não pode ser negativo")
    @NotNull(message = "valor solicitado não pode ser nulo")
    private Double valorSolicitado;
    @DecimalMin(value = "0.0", message = "valor aprovado não pode ser negativo")
    @NotNull(message = "valor aprovado não pode ser nulo")
    private Double valorAprovado;
    @DecimalMin(value = "0.0", message = "taxa juros não pode ser negativo")
    @NotNull(message = "taxa juros não pode ser nulo")
    private Double taxaJuros;
    @Min(value = 0, message = "parcelas não pode ser negativo")
    @NotNull(message = "parcelas não pode ser nulo")
    private Integer parcelas;
    @NotNull(message = "data aprovacao não pode ser nulo")
    private java.time.LocalDateTime dataAprovacao;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public Long getGrupoId() { return grupoId; }
    public void setGrupoId(Long grupoId) { this.grupoId = grupoId; }
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
