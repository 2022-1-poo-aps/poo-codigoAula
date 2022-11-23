package br.ufpb.dcx.rodrigor.poo.strategy.produto;

public class CalculaImpostoFrutas implements CalculadorImposto{

    private final double IMPOSTO_FRUTAS = 0.048;
    @Override
    public Double calcularImposto(Double valor) {
        return valor * IMPOSTO_FRUTAS;
    }
}
