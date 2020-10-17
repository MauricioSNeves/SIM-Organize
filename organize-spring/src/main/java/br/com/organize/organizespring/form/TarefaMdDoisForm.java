package br.com.organize.organizespring.form;

import br.com.organize.organizespring.model.Evento;
import br.com.organize.organizespring.model.TarefaMdDois;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TarefaMdDoisForm {

    @NotNull @NotEmpty
    private String nomeTarefaMdDois;
    @NotNull @NotEmpty
    private Integer tempoRestante;
    private Date dataCriacao;
    private Integer statusMdDois;

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

    public void setStatusMdDois(Integer statusMdDois) {
        this.statusMdDois = statusMdDois;
    }
    public TarefaMdDois converter(){
        return new TarefaMdDois(nomeTarefaMdDois, tempoRestante, dataCriacao, statusMdDois);
    }

}
