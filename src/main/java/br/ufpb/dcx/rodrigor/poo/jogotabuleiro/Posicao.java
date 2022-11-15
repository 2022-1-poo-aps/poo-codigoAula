package br.ufpb.dcx.rodrigor.poo.jogotabuleiro;

import java.util.Objects;

public class Posicao {

    public int x;
    public int y;


    public Posicao(){}


    public Posicao(int x, int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString() {
        return "["+x+","+y+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicao posicao = (Posicao) o;
        return x == posicao.x && y == posicao.y;
    }

    /**
     * Gera uma instância de Posição a partir de um String no formato x,y
     * @param texto string no formato x,y
     * @return uma nova Posição
     */
    public static Posicao getInstance(String texto){
        String[] xy = texto.split(",");
        Posicao nova = new Posicao();
        nova.x = Integer.parseInt(xy[0]);
        nova.y = Integer.parseInt(xy[1]);
        return nova;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
