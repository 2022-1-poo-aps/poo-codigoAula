package br.ufpb.dcx.rodrigor.poo.jogodamas;

import br.ufpb.dcx.rodrigor.poo.jogotabuleiro.Cor;
import br.ufpb.dcx.rodrigor.poo.jogotabuleiro.Tabuleiro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JogoDamasTest {

    JogoDamas jogoDamas;

    @BeforeEach
    void setup(){
        jogoDamas = new JogoDamas();
    }

    @Test
    void fazerSetupDamas() {
        Tabuleiro tabDamas = jogoDamas.getTabuleiro();

        assertTrue(tabDamas.getCasa(0,0).temPeca());
        assertEquals(Cor.preto,tabDamas.getCasa(0,0).getCor());
        assertFalse(tabDamas.getCasa(0,1).temPeca());
        // (...)
    }
}