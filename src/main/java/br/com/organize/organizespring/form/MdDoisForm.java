package br.com.organize.organizespring.form;

import br.com.organize.organizespring.model.Evento;
import br.com.organize.organizespring.model.MdDois;
import br.com.organize.organizespring.model.MdUm;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MdDoisForm {

    @NotNull @NotEmpty
    private String nomeMetaMdDois;

    public String getNomeMetaMdDois() {
        return nomeMetaMdDois;
    }

    public void setNomeMetaMdDois(String nomeMetaMdDois) {
        this.nomeMetaMdDois = nomeMetaMdDois;
    }

    public MdDois converter(){
        return new MdDois(nomeMetaMdDois);
    }

}