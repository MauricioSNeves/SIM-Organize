package br.com.organize.organizespring.dto;

import br.com.organize.organizespring.model.MetodoDx;

import java.time.LocalDate;

public class MetodoDxDto {

    private Integer idMetodoDx;
    private LocalDate dataConclusaoDx;
    private String nomeMci;
    private String nomeDx;
    private long semanas;
    private LocalDate dataInicioDx;



    public MetodoDxDto(MetodoDx metodoDx) {
        this.idMetodoDx = metodoDx.getIdMetodoDx();
        this.dataConclusaoDx = metodoDx.getDataConclusaoDx();
        this.nomeMci = metodoDx.getNomeMci();
        this.nomeDx = metodoDx.getNomeDx();
        this.semanas = metodoDx.getSemanas();
        this.dataInicioDx = metodoDx.getDataInicioDx();

    }

    public LocalDate  getDataConclusaoDx() {
        return dataConclusaoDx;
    }

    public String getNomeMci() {
        return nomeMci;
    }

    public Integer getIdMetodoDx() {
        return idMetodoDx;
    }

    public String getNomeDx() {
        return nomeDx;
    }

    public long getSemanas() {
        return semanas;
    }

    public LocalDate getDataInicioDx() {
        return dataInicioDx;
    }
}
