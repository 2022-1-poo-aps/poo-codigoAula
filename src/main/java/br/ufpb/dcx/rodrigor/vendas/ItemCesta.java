package br.ufpb.dcx.rodrigor.vendas;

public class ItemCesta {

    private Produto produto;
    private Integer quant;

    public ItemCesta(Produto produto, Integer quant){
        this.produto = produto;
        this.setQuant(quant);
    }

    public ItemCesta(Produto produto){
        this(produto,1);
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        if(quant <= 0){
            throw new IllegalArgumentException("Quantidade não pode ser menor ou igual a zero!");
        }
        this.quant = quant;
    }

    public Integer incrementar(){
        return ++this.quant;
    }

    public Integer incrementar(int incremento){
        this.quant+=incremento;
        return this.quant;
    }


    public double getTotalItem(){
        return this.quant * produto.getPreco();
    }
}
