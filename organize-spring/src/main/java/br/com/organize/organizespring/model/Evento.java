package br.com.organize.organizespring.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvento;
    private Date dataInicio;
    private Date dataFinal;
    private String local;
    private String descricao;
    private String prioridade;
    private Boolean status;

    @ManyToOne
    private Calendario calendario;

    public Evento() {

    }

    public Evento(Date dataInicio, Date dataFinal, String local, String descricao, String prioridade, Boolean status) {
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.local = local;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }
}
