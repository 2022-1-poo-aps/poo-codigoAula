package br.ufpb.dcx.rodrigor.vendas;

public class Produto {

    private String nome;
    private Integer codigo;
    private String descricao;
    private double preco;

    public Produto(Integer codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = "";
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if(preco < 0){
            throw new IllegalArgumentException("Valor inválido!");
        }
        this.preco = preco;
    }
}
