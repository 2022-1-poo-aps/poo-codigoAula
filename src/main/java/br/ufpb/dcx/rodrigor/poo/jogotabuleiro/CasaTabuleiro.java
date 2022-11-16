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

    public boolean temPeca(){
        return this.peca != null;
    }

    public boolean temPecaMesmaCor(PecaDamas peca){
        if(!temPeca()) return false;
        return getPeca().getCor().equals(peca.getCor());
    }

    public void removerPeca() {
        this.peca = null;
    }
}
