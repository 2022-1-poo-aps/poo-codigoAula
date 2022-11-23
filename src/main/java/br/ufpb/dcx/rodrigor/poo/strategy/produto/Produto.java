package br.ufpb.dcx.rodrigor.poo.strategy.produto;

import java.time.LocalDate;

public class Produto  {

    private int codigo;
    private String nome;
    private Double valor;
    private LocalDate dataValidade;

    private CalculadorImposto calculadorImposto;

    public Produto(int codigo, String nome, Double valor, CalculadorImposto calculadorImposto){
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.calculadorImposto = calculadorImposto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return valor + calculadorImposto.calcularImposto(valor);
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}
