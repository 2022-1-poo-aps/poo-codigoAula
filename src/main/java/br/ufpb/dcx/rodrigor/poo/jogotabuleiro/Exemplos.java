package br.ufpb.dcx.rodrigor.poo.jogotabuleiro;

public class Exemplos {

    public static void main(String[] args) {

        PecaDamas peca = new PecaDamas(Cor.preto);

        Tabuleiro tabuleiro = new Tabuleiro();

        tabuleiro.mover(new Posicao(0,0), new Posicao(0,3));

    }
}
