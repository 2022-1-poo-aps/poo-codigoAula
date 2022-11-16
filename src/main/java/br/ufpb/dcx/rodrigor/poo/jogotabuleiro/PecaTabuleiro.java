package br.ufpb.dcx.rodrigor.poo.jogotabuleiro;

import java.time.Period;

public class PecaTabuleiro {

    private Cor cor;
    private RegraMovimentacao regra;

//    public PecaTabuleiro(Cor cor){
//        this.cor = cor;
//    }

    public PecaTabuleiro(Cor cor, RegraMovimentacao regra){
        this.cor = cor;
        this.regra = regra;
    }

    public Cor getCor() {
        return cor;
    }


    public String toString(){
        return (cor.equals(Cor.preto)?"●":"◯");
    }

    public boolean movimentoValido(Posicao origem, Posicao destino, Tabuleiro tabuleiro) throws MovimentoInvalidoException {
        return regra.movimentoValido(origem,destino,tabuleiro);
    }

    public RegraMovimentacao getRegra() {
        return regra;
    }

    public void setRegra(RegraMovimentacao regra) {
        this.regra = regra;
    }
}
