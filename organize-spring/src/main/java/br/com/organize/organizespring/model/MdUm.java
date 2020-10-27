package br.com.organize.organizespring.model;

import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;

@Entity
public class MdUm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMdUm;
    private String nomeMetaMdUm;

    @OneToOne(cascade = CascadeType.REMOVE)
    private MetodoDx metodoDx;

    public MdUm() {
    }

    public MdUm(Integer idMdUm, String nomeMetaMdUm, MetodoDx metodoDx) {
        this.idMdUm = idMdUm;
        this.nomeMetaMdUm = nomeMetaMdUm;
        this.metodoDx = metodoDx;
    }

    public MdUm(String nomeMetaMdUm) {
        this.nomeMetaMdUm = nomeMetaMdUm;
    }

    public Integer getIdMdUm() {
        return idMdUm;
    }

    public void setIdMdUm(Integer idMdUm) {
        this.idMdUm = idMdUm;
    }

    public String getNomeMetaMdUm() {
        return nomeMetaMdUm;
    }

    public void setNomeMetaMdUm(String nomeMetaMdUm) {
        this.nomeMetaMdUm = nomeMetaMdUm;
    }

    public MetodoDx getMetodoDx() {
        return metodoDx;
    }

    public void setMetodoDx(MetodoDx metodoDx) {
        this.metodoDx = metodoDx;
    }
}