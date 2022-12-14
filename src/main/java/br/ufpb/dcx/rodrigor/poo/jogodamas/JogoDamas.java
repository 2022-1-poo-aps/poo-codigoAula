package br.ufpb.dcx.rodrigor.poo.jogodamas;

import br.ufpb.dcx.rodrigor.poo.jogotabuleiro.*;
import br.ufpb.dcx.rodrigor.util.Texto;

public class JogoDamas {

    private Tabuleiro tabuleiro;

    public JogoDamas(){
        this.tabuleiro = new Tabuleiro();
    }

    Tabuleiro getTabuleiro(){
        return this.tabuleiro;
    }

    public void fazerSetup(){
        RegraMovimentacao regraDamas = new RegraMovimentacaoDamas();

        tabuleiro.getCasa(0,0).get().setPeca(new PecaTabuleiro(Cor.preto,regraDamas));
        tabuleiro.getCasa(0,2).get().setPeca(new PecaTabuleiro(Cor.preto,regraDamas));
        tabuleiro.getCasa(0,4).get().setPeca(new PecaTabuleiro(Cor.preto,regraDamas));
        tabuleiro.getCasa(0,6).get().setPeca(new PecaTabuleiro(Cor.preto,regraDamas));
        tabuleiro.getCasa(1,1).get().setPeca(new PecaTabuleiro(Cor.preto,regraDamas));
        tabuleiro.getCasa(1,3).get().setPeca(new PecaTabuleiro(Cor.preto,regraDamas));
        tabuleiro.getCasa(1,5).get().setPeca(new PecaTabuleiro(Cor.preto,regraDamas));
        tabuleiro.getCasa(1,7).get().setPeca(new PecaTabuleiro(Cor.preto,regraDamas));
        tabuleiro.getCasa(2,0).get().setPeca(new PecaTabuleiro(Cor.preto,regraDamas));
        tabuleiro.getCasa(2,2).get().setPeca(new PecaTabuleiro(Cor.preto,regraDamas));
        tabuleiro.getCasa(2,4).get().setPeca(new PecaTabuleiro(Cor.preto,regraDamas));
        tabuleiro.getCasa(2,6).get().setPeca(new PecaTabuleiro(Cor.preto,regraDamas));
        tabuleiro.getCasa(5,1).get().setPeca(new PecaTabuleiro(Cor.branco,regraDamas));
        tabuleiro.getCasa(5,3).get().setPeca(new PecaTabuleiro(Cor.branco,regraDamas));
        tabuleiro.getCasa(5,5).get().setPeca(new PecaTabuleiro(Cor.branco,regraDamas));
        tabuleiro.getCasa(5,7).get().setPeca(new PecaTabuleiro(Cor.branco,regraDamas));
        tabuleiro.getCasa(6,0).get().setPeca(new PecaTabuleiro(Cor.branco,regraDamas));
        tabuleiro.getCasa(6,2).get().setPeca(new PecaTabuleiro(Cor.branco,regraDamas));
        tabuleiro.getCasa(6,4).get().setPeca(new PecaTabuleiro(Cor.branco,regraDamas));
        tabuleiro.getCasa(6,6).get().setPeca(new PecaTabuleiro(Cor.branco,regraDamas));
        tabuleiro.getCasa(7,1).get().setPeca(new PecaTabuleiro(Cor.branco,regraDamas));
        tabuleiro.getCasa(7,3).get().setPeca(new PecaTabuleiro(Cor.branco,regraDamas));
        tabuleiro.getCasa(7,5).get().setPeca(new PecaTabuleiro(Cor.branco,regraDamas));
        tabuleiro.getCasa(7,7).get().setPeca(new PecaTabuleiro(Cor.branco,regraDamas));
    }

    public static void main(String[] args) {
        JogoDamas jogo = new JogoDamas();
        jogo.fazerSetup();
        try {
            jogo.lerComandos();
        }catch (Exception exception){
            System.out.println("Me desculpe, mas tivemos um problema interno. Volte mais tarde.");
            exception.printStackTrace();
        }
    }
    public void lerComandos(){
        String comando = "";
        boolean continua = true;
        do {
            System.out.println(tabuleiro);
            comando = Texto.readString("digite o movimento, ou 'sair':\n");
            continua = !comando.equalsIgnoreCase("sair");
            if(!continua) continue;
            try {
                String[] coordenadas = comando.split(" ");
                Posicao origem = Posicao.getInstance(coordenadas[0]);
                Posicao destino = Posicao.getInstance(coordenadas[1]);
                tabuleiro.mover(origem, destino);
            }catch(MovimentoInvalidoException exceptionMov){
                Texto.printAviso(exceptionMov.getMessage());
            }catch(Exception exception){
                Texto.printErro(exception.getMessage());
                //exception.printStackTrace();
            }

        }while(continua);
        Texto.printMsgOK("At?? mais!");
    }



}
