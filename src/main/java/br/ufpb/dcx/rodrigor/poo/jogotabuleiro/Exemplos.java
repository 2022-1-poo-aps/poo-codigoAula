package br.ufpb.dcx.rodrigor.poo.jogotabuleiro;

import br.ufpb.dcx.rodrigor.poo.jogodamas.RegraMovimentacaoDamas;

public class Exemplos {

    public static void main(String[] args) throws MovimentoInvalidoException {

        PecaTabuleiro peca = new PecaTabuleiro(Cor.preto, new RegraMovimentacaoDamas());

        Tabuleiro tabuleiro = new Tabuleiro();

        tabuleiro.mover(new Posicao(0,0), new Posicao(0,3));

    }
}
