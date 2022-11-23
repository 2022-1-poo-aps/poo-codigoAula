package br.ufpb.dcx.rodrigor.poo.lambda;

public class FiguraGeometrica {

    private int[] lados;

    private CalculadorArea calculadorArea;

    public FiguraGeometrica(CalculadorArea calculadorArea){
        this.calculadorArea = calculadorArea;
    }

    public double calcularArea(){
        return calculadorArea.calculaArea(lados);
    }

    public void setLado(int... lados){
        this.lados = lados;
    }

}
