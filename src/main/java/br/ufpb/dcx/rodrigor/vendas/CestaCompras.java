package br.ufpb.dcx.rodrigor.vendas;

import java.util.HashMap;
import java.util.Map;

public class CestaCompras {

    private Map<Integer,ItemCesta> itens = new HashMap<>();


    public Produto addProduto(Produto produto,int quant){
        if(itens.containsKey(produto.getCodigo())){
            itens.get(produto.getCodigo()).incrementar(quant);
        }
        ItemCesta novoItem = new ItemCesta(produto,quant);
        this.itens.put(produto.getCodigo(),novoItem);

        return produto;

    }

    public Produto addProduto(Produto produto){
        return this.addProduto(produto,1);
    }

    public double totalCompra(){
        double total = 0;
        for(ItemCesta item:this.itens.values()){
            total += item.getTotalItem();
        }
        return total;
    }

}
