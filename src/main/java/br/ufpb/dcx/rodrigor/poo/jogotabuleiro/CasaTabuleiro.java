package br.ufpb.dcx.rodrigor.poo.jogotabuleiro;

public class CasaTabuleiro {

    private Cor cor;
    private PecaDamas peca;

    public CasaTabuleiro(Cor cor){
        this.cor = cor;
    }


    public Cor getCor() {
        return cor;
    }

    public PecaDamas getPeca() {
        return peca;
    }

    public void setPeca(PecaDamas peca) {
        this.peca = peca;
    }
}
