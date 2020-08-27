package br.com.organize.organizespring.dto;

import br.com.organize.organizespring.model.TarefaMdUm;
//import com.sun.corba.se.spi.orbutil.fsm.StateEngineFactory;

import java.util.Date;

public class TarefaMdUmDto {

    private Integer idTarefaMdUm;
    private String nomeTarefaMdUm;
    private Integer tempoRestante;
    private Date dataCriacao;
    private Boolean statusMdUm;

    public TarefaMdUmDto(TarefaMdUm tarefaMdUm) {
        this.idTarefaMdUm = tarefaMdUm.getIdTarefaMdUm();
        this.nomeTarefaMdUm = tarefaMdUm.getNomeTarefaMdUm();
        this.tempoRestante = tarefaMdUm.getTempoRestante();
        this.dataCriacao = tarefaMdUm.getDataCriacao();
        this.statusMdUm = tarefaMdUm.getStatusMdUm();
    }

    public Integer getIdTarefaMdUm() {
        return idTarefaMdUm;
    }

    public String getNomeTarefaMdUm() {
        return nomeTarefaMdUm;
    }

    public Integer getTempoRestante() {
        return tempoRestante;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Boolean getStatusMdUm() {
        return statusMdUm;
    }
}
