package br.com.organize.organizespring.util;

import java.util.List;

public class Basic extends Assinatura {

    public Basic(String nome, Double preco, int duracao) {
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
