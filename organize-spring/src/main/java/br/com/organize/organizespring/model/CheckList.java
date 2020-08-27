package br.com.organize.organizespring.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class CheckList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChecklist;

    @OneToOne
    private Usuario usuario;

    public Integer getIdChecklist() {
        return idChecklist;
    }

    public void setIdChecklist(Integer idChecklist) {
        this.idChecklist = idChecklist;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
