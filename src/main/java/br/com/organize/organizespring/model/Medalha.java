package br.com.organize.organizespring.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Medalha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedalha;

    private String descricao;
    private String medalha;
    private String nome;
    private Integer level;
    private Boolean disponivel;

    @ManyToMany(mappedBy = "medalhas")
    private List<Usuario> usuarios;

    public Medalha() {

    }

    public Medalha(Integer idMedalha, String descricao, String medalha, String nome, Integer level, Boolean disponivel, List<Usuario> usuarios) {
        this.idMedalha = idMedalha;
        this.descricao = descricao;
        this.medalha = medalha;
        this.nome = nome;
        this.level = level;
        this.disponivel = disponivel;
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Integer getIdMedalha() {
        return idMedalha;
    }

    public void setIdMedalha(Integer idMedalha) {
        this.idMedalha = idMedalha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMedalha() {
        return medalha;
    }

    public void setMedalha(String medalha) {
        this.medalha = medalha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}