package br.com.organize.organizespring.form;

import br.com.organize.organizespring.model.Evento;
import br.com.organize.organizespring.model.TarefaMdUm;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TarefaMdUmForm {

    @NotNull @NotEmpty
    private String nomeTarefaMdUm;
    @NotNull @NotEmpty
    private Integer tempoRestante;
    private Date dataCriacao;
    private Boolean statusMdUm;

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

    public Boolean getStatusMdUm() {
        return statusMdUm;
    }

    public void setStatusMdUm(Boolean statusMdUm) {
        this.statusMdUm = statusMdUm;
    }

    public TarefaMdUm converter(){
        return new TarefaMdUm(nomeTarefaMdUm, tempoRestante,dataCriacao,statusMdUm);
    }

}
