package com.microfinancasapi.dto;

import jakarta.validation.constraints.*;

public class ParcelaRequestDTO {

    @NotNull(message = "EmprestimoId é obrigatório")
    @Positive(message = "EmprestimoId deve ser um ID válido (positivo)")
    private Long emprestimoId;
    @Min(value = 0, message = "numero não pode ser negativo")
    @NotNull(message = "numero não pode ser nulo")
    private Integer numero;
    @NotNull(message = "data vencimento não pode ser nulo")
    private java.time.LocalDateTime dataVencimento;
    @DecimalMin(value = "0.0", message = "valor parcela não pode ser negativo")
    @NotNull(message = "valor parcela não pode ser nulo")
    private Double valorParcela;
    @DecimalMin(value = "0.0", message = "valor pago não pode ser negativo")
    @NotNull(message = "valor pago não pode ser nulo")
    private Double valorPago;
    @NotNull(message = "data pagamento não pode ser nulo")
    private java.time.LocalDateTime dataPagamento;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getEmprestimoId() { return emprestimoId; }
    public void setEmprestimoId(Long emprestimoId) { this.emprestimoId = emprestimoId; }
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
