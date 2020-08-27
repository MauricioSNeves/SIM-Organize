package br.com.organize.organizespring.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TarefaMdDois {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTarefaMdDois;
    private String nomeTarefaMdDois;
    private Integer tempoRestante;
    private Date dataCriacao;
    private Boolean statusMdDois;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MdDois mdDois;

    public TarefaMdDois(){

    }

    public TarefaMdDois(String nomeTarefaMdDois, Integer tempoRestante, Date dataCriacao, Boolean statusMdDois) {
        this.nomeTarefaMdDois = nomeTarefaMdDois;
        this.tempoRestante = tempoRestante;
        this.dataCriacao = dataCriacao;
        this.statusMdDois = statusMdDois;
    }

    public Integer getIdTarefaMdDois() {
        return idTarefaMdDois;
    }

    public void setIdTarefaMdDois(Integer idTarefaMdDois) {
        this.idTarefaMdDois = idTarefaMdDois;
    }

    public String getNomeTarefaMdDois() {
        return nomeTarefaMdDois;
    }

    public void setNomeTarefaMdDois(String nomeTarefaMdDois) {
        this.nomeTarefaMdDois = nomeTarefaMdDois;
    }

    public Integer getTempoRestante() {
        return tempoRestante;
    }

    public void setTempoRestante(Integer tempoRestante) {
        this.tempoRestante = tempoRestante;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Boolean getStatusMdDois() {
        return statusMdDois;
    }

    public void setStatusMdDois(Boolean statusMdDois) {
        this.statusMdDois = statusMdDois;
    }

    public MdDois getMdDois() {
        return mdDois;
    }

    public void setMdDois(MdDois mdDois) {
        this.mdDois = mdDois;
    }
}
