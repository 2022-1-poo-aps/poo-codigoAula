package br.ufpb.dcx.rodrigor.poo.jogodamas;

import br.ufpb.dcx.rodrigor.poo.jogotabuleiro.*;

import java.util.LinkedList;
import java.util.List;

public class RegraMovimentacaoDamas implements RegraMovimentacao {
    @Override
    public boolean movimentoValido(Posicao origem, Posicao destino, Tabuleiro tabuleiro) throws MovimentoInvalidoException {
        PecaTabuleiro pecaOrigem = tabuleiro.getCasa(origem).get().getPeca();
        // Checar movimento da peça do jogo de Damas:
        List<MovimentoPossivel> possiveisSimples = new LinkedList<>();

        //peças vizinhas
        //TODO: considerar a situação onde as peças não podem "voltar". Da forma como está implementado, a peça pode fazer um movimento "pra trás"
        //TODO: incluir a informação do "lado" do tabuleiro, onde a peça está localizada. Pensar: isso é o tabuleiro que informa? (refletir sobre isso)
        possiveisSimples.add((orig, dest) -> dest.x == orig.x-1 && dest.y == orig.y+1);
        possiveisSimples.add((orig, dest) -> dest.x == orig.x+1 && dest.y == orig.y+1);
        possiveisSimples.add((orig, dest) -> dest.x == orig.x-1 && dest.y == orig.y-1);
        possiveisSimples.add((orig, dest) -> dest.x == orig.x+1 && dest.y == orig.y-1);


        if(possiveisSimples.stream().anyMatch(possivel -> possivel.movimentoValido(origem, destino))){
            movimentarPeca(origem, destino, tabuleiro);
            return true;
        }

        //capturando peças (1 nível)
        List<MovimentoPossivel> possiveisCaptura = new LinkedList<>();

        //TODO: melhorar o uso do optional usando ifPresent()
        //Lógica aqui: o getCasa retorna um Optional "null" caso a coordenada passada esteja fora dos limites do tabuleiro.
        //isso é necessário para que possamos testar situações onde a coordenada de origem seja na borda do tabuleiro.
        //Por isso verificamos primeiro se a cada "existe" getCasa(...).isPresent()
        possiveisCaptura.add((orig, dest) -> tabuleiro.getCasa(orig.x - 1, orig.y - 1).isPresent() && !tabuleiro.getCasa(orig.x - 1, orig.y - 1).get().temPecaMesmaCor(pecaOrigem) && (dest.x == orig.x - 2 && dest.y == orig.y - 2));
        possiveisCaptura.add((orig, dest) -> tabuleiro.getCasa(orig.x - 1, orig.y - 1).isPresent() && !tabuleiro.getCasa(orig.x - 1, orig.y + 1).get().temPecaMesmaCor(pecaOrigem) && (dest.x == orig.x - 2 && dest.y == orig.y + 2));
        possiveisCaptura.add((orig, dest) -> tabuleiro.getCasa(orig.x - 1, orig.y - 1).isPresent() && !tabuleiro.getCasa(orig.x + 1, orig.y - 1).get().temPecaMesmaCor(pecaOrigem) && (dest.x == orig.x + 2 && dest.y == orig.y - 2));
        possiveisCaptura.add((orig, dest) -> tabuleiro.getCasa(orig.x - 1, orig.y - 1).isPresent() && !tabuleiro.getCasa(orig.x + 1, orig.y + 1).get().temPecaMesmaCor(pecaOrigem) && (dest.x == orig.x + 2 && dest.y == orig.y + 2));

        if(possiveisCaptura.stream().anyMatch(possivel -> possivel.movimentoValido(origem, destino))){
            movimentarPeca(origem, destino,tabuleiro);
            //TODO: implementar captura da peça
        }else {
            throw new MovimentoInvalidoException("Movimento inválido");
        }

        return false;
    }

    public void movimentarPeca(Posicao origem, Posicao destino, Tabuleiro tabuleiro){
        PecaTabuleiro pecaOrigem = tabuleiro.getCasa(origem).get().getPeca();
        tabuleiro.getCasa(destino).get().setPeca(pecaOrigem);
        tabuleiro.getCasa(origem).get().removerPeca();

    }
}
