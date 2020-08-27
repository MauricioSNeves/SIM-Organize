package br.com.organize.organizespring.util;

public abstract class Assinatura implements AssinaturaStratery{

    private String nome;
    private Double preco;
    private int duracao;

    public Assinatura(String nome, Double preco, int duracao) {
        this.nome = nome;
        this.preco = preco;
        this.duracao = duracao;
    }

}
