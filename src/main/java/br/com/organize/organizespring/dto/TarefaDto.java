package br.com.organize.organizespring.dto;

import br.com.organize.organizespring.model.Tarefa;

public class TarefaDto {

    private String nomeTarefa;
    private String nivelImportancia;
    private Boolean statusTarefa;
    private String descricaoTarefa;

    public TarefaDto(Tarefa tarefa) {
        this.nomeTarefa = tarefa.getNomeTarefa();
        this.nivelImportancia = tarefa.getNivelImportancia();
        this.statusTarefa = tarefa.getStatusTarefa();
        this.descricaoTarefa = tarefa.getDescricaoTarefa();
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public String getNivelImportancia() {
        return nivelImportancia;
    }

    public Boolean getStatusTarefa() {
        return statusTarefa;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }
}
