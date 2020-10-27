package br.com.organize.organizespring.model;

import javax.persistence.*;

@Entity
public class MdDois {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMdDois;
    private String nomeMetaMdDois;

    @OneToOne(cascade = CascadeType.REMOVE)
    private MetodoDx metodoDx;

    public MdDois() {
    }

    public MdDois(Integer idMdDois, String nomeMetaMdDois, MetodoDx metodoDx) {
        this.idMdDois = idMdDois;
        this.nomeMetaMdDois = nomeMetaMdDois;
        this.metodoDx = metodoDx;
    }

    public MdDois(String nomeMetaMdDois) {
        this.nomeMetaMdDois = nomeMetaMdDois;
    }

    public Integer getIdMdDois() {
        return idMdDois;
    }

    public void setIdMdDois(Integer idMdDois) {
        this.idMdDois = idMdDois;
    }

    public String getNomeMetaMdDois() {
        return nomeMetaMdDois;
    }

    public void setNomeMetaMdDois(String nomeMetaMdDois) {
        this.nomeMetaMdDois = nomeMetaMdDois;
    }

    public MetodoDx getMetodoDx() {
        return metodoDx;
    }

    public void setMetodoDx(MetodoDx metodoDx) {
        this.metodoDx = metodoDx;
    }
}