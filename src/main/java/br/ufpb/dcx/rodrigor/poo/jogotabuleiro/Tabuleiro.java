package br.ufpb.dcx.rodrigor.poo.jogotabuleiro;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Tabuleiro {

    private int tamTabuleiro;

    private CasaTabuleiro tabuleiro[][];

    public Tabuleiro(int tamTabuleiro) {
        this.tamTabuleiro = tamTabuleiro;
        tabuleiro = new CasaTabuleiro[tamTabuleiro][tamTabuleiro];
        iniciarTabuleiro();
    }

    public Tabuleiro(){
        this(8);
    }

    private void iniciarTabuleiro(){
        for (int i = 0; i < tamTabuleiro; i++) {
            for (int j = 0; j < tamTabuleiro; j++) {
                Cor corPeca = (i+j)%2 == 0? Cor.preto : Cor.branco;
                tabuleiro[i][j] = new CasaTabuleiro(corPeca);
            }
        }
    }

    /**
        x e y têm valores de 0 ao tamanho do tabuleiro -1.
     **/
    public Optional<CasaTabuleiro> getCasa(int x, int y){
        if(x < 0 || y < 0 || x >= tamTabuleiro || y >= tamTabuleiro){
            return Optional.empty();
        }
        return Optional.of(tabuleiro[x][y]);
    }

    public Optional<CasaTabuleiro> getCasa(Posicao posicao){
        return this.getCasa(posicao.x,posicao.y);
    }

    public void mover(Posicao origem, Posicao destino) throws MovimentoInvalidoException {
        // Início das verificações dos parâmetros do método
        if(origem == null){
            throw new IllegalArgumentException("origem é null! ");
        }else if(destino == null){
            throw new IllegalArgumentException("destino é null! ");
        }else if(origem.x < 0 ||
                origem.y < 0 || 
                origem.x>= this.tamTabuleiro || 
                origem.y >= this.tamTabuleiro){
            throw new IllegalArgumentException("Posição origem fora dos limites do tabuleiro. " +
                                               "TamTabuleiro"+this.tamTabuleiro+"- Origem:"+origem);
        } else if(destino.x < 0 ||
                destino.y < 0 ||
                destino.x >=this.tamTabuleiro ||
                destino.y >= this.tamTabuleiro){
            throw new IllegalArgumentException("Posição destino fora dos limites do tabuleiro. " +
                    "TamTabuleiro"+this.tamTabuleiro+"- Destino:"+destino);
        } else if(origem.equals(destino)){
            throw new IllegalArgumentException("Posição Origem = Destino!!: orig:"+origem+", dest:"+destino);
        } else if(!this.getCasa(origem).get().temPeca()){
            throw new MovimentoInvalidoException("Não existe peça na origem");
        }

        PecaDamas pecaOrigem= this.getCasa(origem).get().getPeca();

        if (this.getCasa(destino).get().temPeca()){
            throw new MovimentoInvalidoException("Movimento inválido");
        }
        // Fim das verificações dos parâmetros do método


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
            movimentarPeca(origem, destino);
            return;
        }

        //capturando peças (1 nível)
        List<MovimentoPossivel> possiveisCaptura = new LinkedList<>();

        //TODO: melhorar o uso do optional usando ifPresent()
        //Lógica aqui: o getCasa retorna um Optional "null" caso a coordenada passada esteja fora dos limites do tabuleiro.
        //isso é necessário para que possamos testar situações onde a coordenada de origem seja na borda do tabuleiro.
        //Por isso verificamos primeiro se a cada "existe" getCasa(...).isPresent()
        possiveisCaptura.add((orig, dest) -> getCasa(orig.x - 1, orig.y - 1).isPresent() && !getCasa(orig.x - 1, orig.y - 1).get().temPecaMesmaCor(pecaOrigem) && (dest.x == orig.x - 2 && dest.y == orig.y - 2));
        possiveisCaptura.add((orig, dest) -> getCasa(orig.x - 1, orig.y - 1).isPresent() && !getCasa(orig.x - 1, orig.y + 1).get().temPecaMesmaCor(pecaOrigem) && (dest.x == orig.x - 2 && dest.y == orig.y + 2));
        possiveisCaptura.add((orig, dest) -> getCasa(orig.x - 1, orig.y - 1).isPresent() && !getCasa(orig.x + 1, orig.y - 1).get().temPecaMesmaCor(pecaOrigem) && (dest.x == orig.x + 2 && dest.y == orig.y - 2));
        possiveisCaptura.add((orig, dest) -> getCasa(orig.x - 1, orig.y - 1).isPresent() && !getCasa(orig.x + 1, orig.y + 1).get().temPecaMesmaCor(pecaOrigem) && (dest.x == orig.x + 2 && dest.y == orig.y + 2));

        if(possiveisSimples.stream().anyMatch(possivel -> possivel.movimentoValido(origem, destino))){
            movimentarPeca(origem, destino);
            //TODO: implementar captura da peça
        }else {
            throw new MovimentoInvalidoException("Movimento inválido");
        }
    }

    public void movimentarPeca(Posicao origem, Posicao destino){
        PecaDamas pecaOrigem = getCasa(origem).get().getPeca();
        getCasa(destino).get().setPeca(pecaOrigem);
        getCasa(origem).get().removerPeca();

    }


    public int getTamanho() {
        return this.tamTabuleiro;
    }

    @Override
    public String toString() {
        StringBuffer tabtxt = new StringBuffer();
        // ┌ ┬ ┐ └ ┴ ┘ ┤ ├ │ ┼  ─
        String hborder = "─".repeat(3);
        String topBorder =    "  ┌"+(hborder+"┬").repeat(tabuleiro.length-1)+hborder+"┐\n";
//        String midBorder =    " ├"+(hborder+"┼").repeat(tabuleiro.length-1)+hborder+"┤\n";
        String bottonBorder = "  └"+(hborder+"┴").repeat(tabuleiro.length-1)+hborder+"┘\n";

        boolean nextX, nextY;
        // top numbers
        tabtxt.append("  ");
        for (int x = 0; x < tabuleiro.length; x++) {
            tabtxt.append(String.format("  %s ", x));
        }
        tabtxt.append("\n");


        tabtxt.append(topBorder);
        for (int y = 0; y < tabuleiro.length; y++) {
  //          nextY = y+1 < tabuleiro.length;
            tabtxt.append(y+" ");
            for (int x = 0; x < tabuleiro.length; x++) {
                nextX = x+1 < tabuleiro.length;

                CasaTabuleiro casa = tabuleiro[y][x];
                String cortxt = casa.temPeca()?casa.getCor().equals(Cor.preto)?"█"+casa.getPeca()+"█":" "+casa.getPeca()+" ":casa.getCor().equals(Cor.preto)?"███":"   ";
                tabtxt.append("│"+cortxt+(nextX?"":"│\n"));
            }
//            if(nextY){
//                tabtxt.append(midBorder);
//            }
        }
        tabtxt.append(bottonBorder);

        return tabtxt.toString();
    }



    public static void main(String[] args) {
        Tabuleiro t = new Tabuleiro();
        System.out.println(t.toString());
    }
}
