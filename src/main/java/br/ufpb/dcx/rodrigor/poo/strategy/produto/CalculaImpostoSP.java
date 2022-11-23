package br.ufpb.dcx.rodrigor.poo.strategy.produto;

public class CalculaImpostoSP implements CalculadorImposto{

    private final Double IMPOSTO_SP = 0.12;
    @Override
    public Double calcularImposto(Double valor) {
        return valor * IMPOSTO_SP;
    }
}
