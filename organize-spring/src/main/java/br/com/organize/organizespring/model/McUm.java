package br.com.organize.organizespring.model;

import javax.persistence.*;

@Entity
public class McUm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMcUm;

    private String nome;
    private String descricao;


    @OneToOne(cascade = CascadeType.REMOVE)
    private MetodoDx metodoDx;

    public Integer getIdMcUm() {
        return idMcUm;
    }

    public void setIdMcUm(Integer idMcUm) {
        this.idMcUm = idMcUm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public MetodoDx getMetodoDx() {
        return metodoDx;
    }

    public void setMetodoDx(MetodoDx metodoDx) {
        this.metodoDx = metodoDx;
    }
}