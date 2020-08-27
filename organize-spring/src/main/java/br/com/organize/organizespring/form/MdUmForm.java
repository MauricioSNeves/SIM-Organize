package br.com.organize.organizespring.form;

import br.com.organize.organizespring.model.Evento;
import br.com.organize.organizespring.model.MdUm;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MdUmForm {

    @NotNull @NotEmpty
    private String nomeMetaMdUm;

    public String getNomeMetaMdUm() {
        return nomeMetaMdUm;
    }

    public void setNomeMetaMdUm(String nomeMetaMdUm) {
        this.nomeMetaMdUm = nomeMetaMdUm;
    }

    public MdUm converter(){
        return new MdUm(nomeMetaMdUm);
    }

}