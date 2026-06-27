package com.microfinancasapi.dto;

public class ClienteResponseDTO {

    private Long id;
    private Long grupoId;
    private String nome;
    private String cpf;
    private Double renda;
    private String ocupacao;
    private String referencias;
    private Integer score;
    private Boolean status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
