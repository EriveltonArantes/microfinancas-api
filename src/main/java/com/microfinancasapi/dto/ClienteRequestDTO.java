package com.microfinancasapi.dto;

import jakarta.validation.constraints.*;

public class ClienteRequestDTO {

    @NotNull(message = "GrupoId é obrigatório")
    @Positive(message = "GrupoId deve ser um ID válido (positivo)")
    private Long grupoId;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "cpf não pode estar em branco")
    @Size(min = 11, max = 14, message = "cpf deve ter entre 11 e 14 dígitos")
    private String cpf;
    @NotNull(message = "renda não pode ser nulo")
    private Double renda;
    @NotBlank(message = "ocupacao não pode estar em branco")
    private String ocupacao;

    private String referencias;
    @Min(value = 0, message = "score não pode ser negativo")
    @NotNull(message = "score não pode ser nulo")
    private Integer score;
    @NotNull(message = "status não pode ser nulo")
    private Boolean status;

    public Long getGrupoId() { return grupoId; }
    public void setGrupoId(Long grupoId) { this.grupoId = grupoId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public Double getRenda() { return renda; }
    public void setRenda(Double renda) { this.renda = renda; }
    public String getOcupacao() { return ocupacao; }
    public void setOcupacao(String ocupacao) { this.ocupacao = ocupacao; }
    public String getReferencias() { return referencias; }
    public void setReferencias(String referencias) { this.referencias = referencias; }
    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
