package br.com.organize.organizespring.dto;

import br.com.organize.organizespring.model.TarefaMdDois;

import java.util.Date;

public class TarefaMdDoisDto {

    private Integer idTarefaMdDois;
    private String nomeTarefaMdDois;
    private Integer tempoRestante;
    private Date dataCriacao;
    private Boolean statusMdDois;

    public TarefaMdDoisDto(TarefaMdDois tarefaMdDois) {
        this.idTarefaMdDois = tarefaMdDois.getIdTarefaMdDois();
        this.nomeTarefaMdDois = tarefaMdDois.getNomeTarefaMdDois();
        this.tempoRestante = tarefaMdDois.getTempoRestante();
        this.dataCriacao = tarefaMdDois.getDataCriacao();
        this.statusMdDois = tarefaMdDois.getStatusMdDois();
    }

    public Integer getIdTarefaMdDois() {
        return idTarefaMdDois;
    }

    public String getNomeTarefaMdDois() {
        return nomeTarefaMdDois;
    }

    public Integer getTempoRestante() {
        return tempoRestante;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Boolean getStatusMdDois() {
        return statusMdDois;
    }
}
