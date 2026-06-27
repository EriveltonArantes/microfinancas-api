package com.microfinancasapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String cpf;
    private Double renda;
    @Column(nullable = false)
    private String ocupacao;
    private String referencias;
    private Integer score;
    private Boolean status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Grupo getGrupo() { return grupo; }
    public void setGrupo(Grupo grupo) { this.grupo = grupo; }
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
