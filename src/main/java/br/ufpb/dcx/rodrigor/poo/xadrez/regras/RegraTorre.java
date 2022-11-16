package br.ufpb.dcx.rodrigor.poo.xadrez.regras;

import br.ufpb.dcx.rodrigor.poo.jogotabuleiro.MovimentoInvalidoException;
import br.ufpb.dcx.rodrigor.poo.jogotabuleiro.Posicao;
import br.ufpb.dcx.rodrigor.poo.jogotabuleiro.RegraMovimentacao;
import br.ufpb.dcx.rodrigor.poo.jogotabuleiro.Tabuleiro;

public class RegraTorre implements RegraMovimentacao {
    @Override
    public boolean movimentoValido(Posicao origem, Posicao destino, Tabuleiro tabuleiro) throws MovimentoInvalidoException {
        return false;
    }
}
