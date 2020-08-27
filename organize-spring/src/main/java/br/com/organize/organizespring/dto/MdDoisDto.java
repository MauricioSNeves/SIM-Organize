package br.com.organize.organizespring.dto;

import br.com.organize.organizespring.model.MdDois;

public class MdDoisDto {

    private String nomeMetaMdDois;

    public MdDoisDto(MdDois MdDois) {
        this.nomeMetaMdDois = MdDois.getNomeMetaMdDois();
    }

    public String getNomeMetaMdUm() {
        return nomeMetaMdDois;
    }

}