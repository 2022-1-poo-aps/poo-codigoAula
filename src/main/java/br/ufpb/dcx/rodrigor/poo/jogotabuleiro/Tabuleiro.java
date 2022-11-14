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

    public void mover(Posicao origem, Posicao destino){
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

    }


    public int getTamanho() {
        return this.tamTabuleiro;
    }
}
