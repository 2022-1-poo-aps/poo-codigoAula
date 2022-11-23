package br.ufpb.dcx.rodrigor.poo.lambda;

public class Exemplo {

    public static void main(String[] args) {

        FiguraGeometrica quadrado = new FiguraGeometrica((lados) -> lados[0]*lados[1]);

        quadrado.setLado(2,2);
        System.out.println(quadrado.calcularArea());


    }
}
