package br.com.organize.organizespring.model;

import javax.persistence.*;

@Entity
public class MdDois {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMdDois;
    private String nomeMetaMdDois;

//    @OneToOne
//    @OneToOne(cascade = CascadeType.REMOVE)
//    private MCDois mcDois;

    @OneToOne(cascade = CascadeType.REMOVE)
    private MetodoDx metodoDx;

    public MdDois() {
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

//    public MCDois getMcDois() {
//        return mcDois;
//    }
//
//    public void setMcDois(MCDois mcDois) {
//        this.mcDois = mcDois;
//    }


    public MetodoDx getMetodoDx() {
        return metodoDx;
    }

    public void setMetodoDx(MetodoDx metodoDx) {
        this.metodoDx = metodoDx;
    }
}