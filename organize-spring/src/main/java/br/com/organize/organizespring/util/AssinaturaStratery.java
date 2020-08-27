package br.com.organize.organizespring.util;

import java.util.List;

public interface AssinaturaStratery {

    public List<String> escolheTemasPadrões(List<String> temas, int quantidade);
    public Integer calculoDeXpPorNivel(int xpAtual);

}
