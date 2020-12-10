package br.com.organize.organizespring.dto;

import br.com.organize.organizespring.model.MdUm;

public class MdUmDto {

    private String nomeMetaMdUm;

    public MdUmDto(MdUm mdUm) {
        this.nomeMetaMdUm = mdUm.getNomeMetaMdUm();
    }

    public String getNomeMetaMdUm() {
        return nomeMetaMdUm;
    }

}