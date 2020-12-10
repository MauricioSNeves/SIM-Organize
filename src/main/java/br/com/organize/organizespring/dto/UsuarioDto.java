package br.com.organize.organizespring.dto;

import br.com.organize.organizespring.model.Usuario;

public class UsuarioDto {

    private Long idUsuario;
    private String nomeUser;
    private String tipoAcesso;
    private String email;
    private String senha;
    private Integer nivel;
    private Integer moedas;
    private String cpf;

    public UsuarioDto(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nomeUser = usuario.getNomeUser();
        this.tipoAcesso = usuario.getTipoAcesso();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.nivel = usuario.getNivel();
        this.moedas = usuario.getMoedas();
        this.cpf = usuario.getCpf();
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public String getTipoAcesso() {
        return tipoAcesso;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Integer getNivel() {
        return nivel;
    }

    public Integer getMoedas() {
        return moedas;
    }

    public String getCpf() {
        return cpf;
    }
}
