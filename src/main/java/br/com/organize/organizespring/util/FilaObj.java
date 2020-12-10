package br.com.organize.organizespring.util;

public class FilaObj <T> {
    private int tamanho;
    private T[] fila;

    public FilaObj(int capacidade) {
        tamanho = 0;
        fila = (T[]) new Object[capacidade];
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

    public boolean isFull(){
        return tamanho == fila.length;
    }

    public void insert(T info){
        if(!isFull()){
            fila[tamanho++] = info;
        }else {
            System.out.println("Fila Cheia");
        }
    }

    public T peek(){
        return fila[0];
    }

    public T pool(){
        T valor = fila[0];
        if(!isEmpty()){
            for (int i = 0; i<tamanho; i++){
                if (i == tamanho-1){
                    break;
                }else{
                    fila[i] = fila[i+1];
                }
            }
            tamanho--;
            return valor;
        }else{
            return null;
        }
    }

    public void exibe(){
        if (isEmpty()){
            System.out.println("Fila vazia");
        }else{
            for (int i = 0; i < tamanho; i++){
                System.out.println(fila[i]);
            }
        }
    }

}
