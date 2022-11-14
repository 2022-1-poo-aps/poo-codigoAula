package br.ufpb.dcx.rodrigor.poo.jogotabuleiro;

public class Posicao {

    public int x;
    public int y;


    public Posicao(int x, int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString() {
        return "["+x+","+y+"]";
    }
}
