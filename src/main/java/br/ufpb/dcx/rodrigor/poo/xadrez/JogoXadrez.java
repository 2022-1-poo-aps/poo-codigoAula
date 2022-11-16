package br.ufpb.dcx.rodrigor.poo.xadrez;

import br.ufpb.dcx.rodrigor.poo.jogodamas.JogoDamas;
import br.ufpb.dcx.rodrigor.poo.jogodamas.RegraMovimentacaoDamas;
import br.ufpb.dcx.rodrigor.poo.jogotabuleiro.Cor;
import br.ufpb.dcx.rodrigor.poo.jogotabuleiro.PecaTabuleiro;
import br.ufpb.dcx.rodrigor.poo.jogotabuleiro.RegraMovimentacao;
import br.ufpb.dcx.rodrigor.poo.jogotabuleiro.Tabuleiro;

public class JogoXadrez {


    //TODO: Implementar Xadrez
    private Tabuleiro tabuleiro;

    public JogoXadrez(){
        tabuleiro = new Tabuleiro();
    }

    public void fazerSetup() {

//        tabuleiro.getCasa(0, 0).get().setPeca(new PecaTabuleiro(Cor.preto, new RegraTorre()));
//        tabuleiro.getCasa(0, 1).get().setPeca(new PecaTabuleiro(Cor.preto, new RegraCavalo()));
//        tabuleiro.getCasa(0, 2).get().setPeca(new PecaTabuleiro(Cor.preto, new RegraBispo()));
//        tabuleiro.getCasa(0, 3).get().setPeca(new PecaTabuleiro(Cor.preto, new RegraDama()));
//        tabuleiro.getCasa(1, 4).get().setPeca(new PecaTabuleiro(Cor.preto, new RegraRei()));
        //...
    }

        public static void main(String[] args) {

        JogoXadrez xadrez = new JogoXadrez();

    }



}
