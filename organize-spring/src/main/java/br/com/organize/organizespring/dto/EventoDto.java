package br.com.organize.organizespring.dto;

import br.com.organize.organizespring.model.Evento;
import java.util.Date;

public class EventoDto {

    private Integer idEvento;
    private Date dataInicio;
    private Date dataFinal;
    private String local;
    private String descricao;
    private String prioridade;
    private Boolean status;

    public EventoDto(Evento evento) {
        this.idEvento = evento.getIdEvento();
        this.dataInicio = evento.getDataInicio();
        this.dataFinal = evento.getDataFinal();
        this.local = evento.getLocal();
        this.descricao = evento.getDescricao();
        this.prioridade = evento.getPrioridade();
        this.status = evento.getStatus();
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public String getLocal() {
        return local;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public Boolean getStatus() {
        return status;
    }

}
