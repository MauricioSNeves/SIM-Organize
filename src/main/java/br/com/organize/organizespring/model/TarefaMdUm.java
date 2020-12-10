package br.com.organize.organizespring.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TarefaMdUm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTarefaMdUm;
    private String nomeTarefaMdUm;
    private Integer tempoRestante;
    private Date dataCriacao;
    private Integer statusMdUm;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MdUm mdUm;

    public TarefaMdUm(){

    }

    public TarefaMdUm(String nomeTarefaMdUm, Integer tempoRestante, Date dataCriacao, Integer statusMdUm) {
        this.nomeTarefaMdUm = nomeTarefaMdUm;
        this.tempoRestante = tempoRestante;
        this.dataCriacao = dataCriacao;
        this.statusMdUm = statusMdUm;
    }

    public Integer getIdTarefaMdUm() {
        return idTarefaMdUm;
    }

    public void setIdTarefaMdUm(Integer idTarefaMdUm) {
        this.idTarefaMdUm = idTarefaMdUm;
    }

    public String getNomeTarefaMdUm() {
        return nomeTarefaMdUm;
    }

    public void setNomeTarefaMdUm(String nomeTarefaMdUm) {
        this.nomeTarefaMdUm = nomeTarefaMdUm;
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

    public Integer getStatusMdUm() {
        return statusMdUm;
    }

    public void setStatusMdUm(Integer statusMdUm) {
        this.statusMdUm = statusMdUm;
    }

    public MdUm getMdUm() {
        return mdUm;
    }

    public void setMdUm(MdUm mdUm) {
        this.mdUm = mdUm;
    }
}
