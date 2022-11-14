package br.ufpb.dcx.rodrigor.poo.jogotabuleiro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabuleiroTest {


    @Test
    public void testeTabuleiro(){
        Tabuleiro tabuleiro = new Tabuleiro();

        int tamanhoPadrao = 8;
        assertNotNull(tabuleiro.getCasa(0,0));
        assertEquals(tamanhoPadrao,tabuleiro.getTamanho());

        for (int i = 0; i < tamanhoPadrao; i++) {
            for (int j = 0; j < tamanhoPadrao; j++) {
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

}