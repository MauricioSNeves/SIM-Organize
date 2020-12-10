package br.com.organize.organizespring.form;


import br.com.organize.organizespring.model.MetodoDx;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class MetodoDxForm {

    @NotNull @NotEmpty
    private LocalDate dataConclusaoDx;
    @NotNull @NotEmpty
    private String nomeMci;
    @NotNull @NotEmpty
    private String nomeDx;

    public LocalDate  getDataConclusaoDx() {
        return dataConclusaoDx;
    }

    public void setDataConclusaoDx(LocalDate dataConclusaoDx) {
        this.dataConclusaoDx = dataConclusaoDx;
    }

    public String getNomeMci() {
        return nomeMci;
    }

    public void setNomeMci(String nomeMci) {
        this.nomeMci = nomeMci;
    }

    public String getNomeDx() {
        return nomeDx;
    }

    public void setNomeDx(String nomeDx) {
        this.nomeDx = nomeDx;
    }

    public MetodoDx converter(){
        return new MetodoDx(nomeDx, dataConclusaoDx,nomeMci);
    }


}
