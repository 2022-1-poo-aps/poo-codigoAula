package br.ufpb.dcx.rodrigor.poo.jogotabuleiro;

public class PecaDamas {

    private Cor cor;

    public PecaDamas(Cor cor){
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }


    public String toString(){
        return (cor.equals(Cor.preto)?"●":"◯");
    }


}
