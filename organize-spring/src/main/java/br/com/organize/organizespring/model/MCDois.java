package br.com.organize.organizespring.model;


import javax.persistence.*;

@Entity
public class MCDois {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMCdois;
    private String nome;
    private String descricao;

    @OneToOne
    private MetodoDx metodoDx;

    public MCDois(Integer idMCdois, String nome, String descricao) {
        this.idMCdois = idMCdois;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getIdMCdois() {
        return idMCdois;
    }

    public void setIdMCdois(Integer idMCdois) {
        this.idMCdois = idMCdois;
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
