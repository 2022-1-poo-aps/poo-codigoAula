package br.ufpb.dcx.rodrigor.poo.jogotabuleiro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabuleiroTest {

    private Tabuleiro tabuleiro;
    private int TAM_PADRAO = 8;
    @BeforeEach
    public void setup(){
        tabuleiro = new Tabuleiro();
    }

    @Test
    public void testeTabuleiro(){
        assertNotNull(tabuleiro.getCasa(0,0));
        assertEquals(TAM_PADRAO,tabuleiro.getTamanho());

        for (int i = 0; i < TAM_PADRAO; i++) {
            for (int j = 0; j < TAM_PADRAO; j++) {
                Cor corEsperada = (i+j)%2==0?Cor.preto:Cor.branco;
                assertEquals(corEsperada,tabuleiro.getCasa(i,j).getCor());
            }
        }

        assertEquals(Cor.preto, tabuleiro.getCasa(0,0).getCor());
        assertEquals(Cor.branco, tabuleiro.getCasa(0,1).getCor());


        Tabuleiro tabuleiro1 = new Tabuleiro(4);
        assertEquals(4,tabuleiro1.getTamanho());
        assertNotNull(tabuleiro1.getCasa(0,0));
    }


    /**
     ** As casas no tabuleiro são armazenadas em coordenadas que vão de 0 até o
     ** tamanho-1;
     **/
    @Test
    public void testeLimitesTabuleiro(){
        assertThrows(IllegalArgumentException.class, () ->
                tabuleiro.getCasa(-1,0));
        assertThrows(IllegalArgumentException.class, () ->
                tabuleiro.getCasa(0,-1));
        assertThrows(IllegalArgumentException.class, () ->
                tabuleiro.getCasa(TAM_PADRAO,0));
        assertThrows(IllegalArgumentException.class, () ->
                tabuleiro.getCasa(0,TAM_PADRAO));

    }
    @Test
    public void testeMover(){
        //testando limites da origem
        assertThrows(IllegalArgumentException.class, () ->
                tabuleiro.mover(new Posicao(-1,0), new Posicao(0,0)));
        assertThrows(IllegalArgumentException.class, () ->
                tabuleiro.mover(new Posicao(0,-1), new Posicao(0,0)));
        assertThrows(IllegalArgumentException.class, () ->
                tabuleiro.mover(new Posicao(TAM_PADRAO,0), new Posicao(0,0)));
        assertThrows(IllegalArgumentException.class, () ->
                tabuleiro.mover(new Posicao(0,TAM_PADRAO), new Posicao(0,0)));

        //testando limites do destino
        assertThrows(IllegalArgumentException.class, () ->
                tabuleiro.mover(new Posicao(0,0), new Posicao(-1,0)));
        assertThrows(IllegalArgumentException.class, () ->
                tabuleiro.mover(new Posicao(0,0), new Posicao(0,-1)));
        assertThrows(IllegalArgumentException.class, () ->
                tabuleiro.mover(new Posicao(0,0), new Posicao(TAM_PADRAO,0)));
        assertThrows(IllegalArgumentException.class, () ->
                tabuleiro.mover(new Posicao(0,0), new Posicao(0,TAM_PADRAO)));

    }


}