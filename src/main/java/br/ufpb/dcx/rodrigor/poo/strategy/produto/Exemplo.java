package br.ufpb.dcx.rodrigor.poo.strategy.produto;

public class Exemplo {


    public static void main(String[] args) {

        Produto chocolate = new Produto(123, "Chocolate Meio Amargo", 8.0, new CalculadorImposto() {
            @Override
            public Double calcularImposto(Double valor) {
                return valor * 0.12;
            }
        });

        Produto banana = new Produto(44,"Banana Pacovan Orgânica", 10.0, (valor) -> valor * 0.048 );

        System.out.println("Preço do Chocolate:"+chocolate.getPreco());


    }
}
