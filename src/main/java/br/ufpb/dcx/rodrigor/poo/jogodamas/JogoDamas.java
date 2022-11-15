package br.ufpb.dcx.rodrigor.poo.jogodamas;

import br.ufpb.dcx.rodrigor.poo.jogotabuleiro.*;
import br.ufpb.dcx.rodrigor.util.Texto;

import java.util.StringTokenizer;

public class JogoDamas {

    private Tabuleiro tabuleiro;

    public JogoDamas(){
        this.tabuleiro = new Tabuleiro();
    }

    Tabuleiro getTabuleiro(){
        return this.tabuleiro;
    }

    public void fazerSetup(){
        tabuleiro.getCasa(0,0).setPeca(new PecaDamas(Cor.preto));
        tabuleiro.getCasa(0,2).setPeca(new PecaDamas(Cor.preto));
        tabuleiro.getCasa(0,4).setPeca(new PecaDamas(Cor.preto));
        tabuleiro.getCasa(0,6).setPeca(new PecaDamas(Cor.preto));
        tabuleiro.getCasa(1,1).setPeca(new PecaDamas(Cor.preto));
        tabuleiro.getCasa(1,3).setPeca(new PecaDamas(Cor.preto));
        tabuleiro.getCasa(1,5).setPeca(new PecaDamas(Cor.preto));
        tabuleiro.getCasa(1,7).setPeca(new PecaDamas(Cor.preto));
        tabuleiro.getCasa(2,0).setPeca(new PecaDamas(Cor.preto));
        tabuleiro.getCasa(2,2).setPeca(new PecaDamas(Cor.preto));
        tabuleiro.getCasa(2,4).setPeca(new PecaDamas(Cor.preto));
        tabuleiro.getCasa(2,6).setPeca(new PecaDamas(Cor.preto));
        tabuleiro.getCasa(5,1).setPeca(new PecaDamas(Cor.branco));
        tabuleiro.getCasa(5,3).setPeca(new PecaDamas(Cor.branco));
        tabuleiro.getCasa(5,5).setPeca(new PecaDamas(Cor.branco));
        tabuleiro.getCasa(5,7).setPeca(new PecaDamas(Cor.branco));
        tabuleiro.getCasa(6,0).setPeca(new PecaDamas(Cor.branco));
        tabuleiro.getCasa(6,2).setPeca(new PecaDamas(Cor.branco));
        tabuleiro.getCasa(6,4).setPeca(new PecaDamas(Cor.branco));
        tabuleiro.getCasa(6,6).setPeca(new PecaDamas(Cor.branco));
        tabuleiro.getCasa(7,1).setPeca(new PecaDamas(Cor.branco));
        tabuleiro.getCasa(7,3).setPeca(new PecaDamas(Cor.branco));
        tabuleiro.getCasa(7,5).setPeca(new PecaDamas(Cor.branco));
        tabuleiro.getCasa(7,7).setPeca(new PecaDamas(Cor.branco));
    }

    public static void main(String[] args) {
        JogoDamas jogo = new JogoDamas();
        jogo.fazerSetup();
        try {
            jogo.lerComandos();
        }catch (Exception exception){
            System.out.println("Me desculpe, mas tivemos um problema interno. Volte mais tarde.");
        }
    }
    public void lerComandos(){
        String comando = "";
        do {
            System.out.println(tabuleiro);
            comando = Texto.readString("digite o movimento, ou 'sair':\n");
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

        }while(!comando.equalsIgnoreCase("sair"));
        Texto.printMsgOK("Até mais!");
    }



}
