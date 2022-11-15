package br.ufpb.dcx.rodrigor.poo.jogotabuleiro;

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
    public CasaTabuleiro getCasa(int x, int y){
        if(x < 0 || y < 0 || x >= tamTabuleiro || y >= tamTabuleiro){
            throw new IllegalArgumentException("x e y têm que ser maiores que zero e menores que "+tamTabuleiro);
        }
        return tabuleiro[x][y];
    }

    public CasaTabuleiro getCasa(Posicao posicao){
        return this.getCasa(posicao.x,posicao.y);
    }

    public void mover(Posicao origem, Posicao destino) throws MovimentoInvalidoException {
        if(origem.x < 0 || 
                origem.y < 0 || 
                origem.x>= this.tamTabuleiro || 
                origem.y >= this.tamTabuleiro){
            throw new IllegalArgumentException("Posição origem fora dos limites do tabuleiro. " +
                                               "TamTabuleiro"+this.tamTabuleiro+"- Origem:"+origem);
        }
        if(destino.x < 0 ||
                destino.y < 0 ||
                destino.x >=this.tamTabuleiro ||
                destino.y >= this.tamTabuleiro){
            throw new IllegalArgumentException("Posição destino fora dos limites do tabuleiro. " +
                    "TamTabuleiro"+this.tamTabuleiro+"- Destino:"+destino);
        }
        if(origem.equals(destino)){
            throw new IllegalArgumentException("Posição Origem = Destino!!: orig:"+origem+", dest:"+destino);
        }

        if(!this.getCasa(origem).temPeca()){
            throw new MovimentoInvalidoException("Não existe peça na origem");
        }

        PecaDamas pecaOrigem= this.getCasa(origem).getPeca();

        if (this.getCasa(destino).temPeca()){
            throw new MovimentoInvalidoException("Movimento inválido");
        }

        if(destino.x == origem.x-1 && destino.y == origem.y+1){
            movimentarPeca(origem,destino);
            return;
        }
        if(destino.x == origem.x+1 && destino.y == origem.y+1){
            movimentarPeca(origem,destino);
            return;
        }

    }

    public void movimentarPeca(Posicao origem, Posicao destino){
        PecaDamas pecaOrigem = getCasa(origem).getPeca();
        getCasa(destino).setPeca(pecaOrigem);
        getCasa(origem).removerPeca();

    }


    public int getTamanho() {
        return this.tamTabuleiro;
    }
}
