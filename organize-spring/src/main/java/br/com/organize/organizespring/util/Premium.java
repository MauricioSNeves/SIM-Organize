package br.com.organize.organizespring.util;

import java.util.List;

public class Premium extends Assinatura {

    public Premium(String nome, Double preco, int duracao) {
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

    public static class ListaObj<Usuario> {
        // Atributos
        private Usuario[] vetor;
        private int nroElem;


        public ListaObj(int tam) {
            vetor = (Usuario[]) new Object[tam];
            nroElem = 0;
        }


        public boolean adiciona(Usuario valor) {
            if (nroElem >= vetor.length) {
                System.out.println("Lista está cheia");
                return false;
            } else {
                vetor[nroElem++] = valor;
                return true;
            }
        }

        public boolean adicionarTodos(List<Usuario> lista) {
            if (nroElem >= vetor.length) {
                System.out.println("Lista está cheia");
                return false;
            } else {

                for (Usuario user : lista) {
                    vetor[nroElem++] = user;
                }
                return true;
            }
        }


        public void exibe() {
            System.out.println("\nExibindo elementos da lista:");
            for (int i = 0; i < nroElem; i++) {
                System.out.println(vetor[i]);
            }
            System.out.println();
        }

        public int busca(Usuario valor) {
            for (int i = 0; i < nroElem; i++) {
                if (vetor[i].equals(valor)) {
                    return i;
                }
            }
            return -1;
        }

        public boolean removePeloIndice(int indice) {
            if (indice < 0 || indice >= nroElem) {
                return false;
            } else {

                for (int i = indice; i < nroElem - 1; i++) {
                    vetor[i] = vetor[i + 1];
                }

                nroElem--;
                return true;
            }
        }

        public boolean removeElemento(Usuario valor) {
            return removePeloIndice(busca(valor));
        }

        public int getTamanho() {
            return nroElem;
        }

        public Usuario getElemento(int indice) {
            if (indice < 0 || indice >= nroElem) {  // se índice for inválido
                return null;                       // retorna false
            } else {
                return vetor[indice];
            }
        }

        public void limpa() {
            nroElem = 0;
        }
    }
}
