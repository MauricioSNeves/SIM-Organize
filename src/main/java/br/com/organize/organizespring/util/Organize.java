package br.com.organize.organizespring.util;

import java.util.List;

public class Organize extends Assinatura{

    public Organize(String nome, Double preco, int duracao) {
        super(nome, preco, duracao);
    }

    @Override
    public List<String> escolheTemasPadrões(List<String> temas, int quantidade) {
        return null;
    }

    @Override
    public Integer calculoDeXpPorNivel(int xpAtual) {
        return null;
    }
}
