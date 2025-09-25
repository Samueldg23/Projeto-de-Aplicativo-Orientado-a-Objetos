package com.unisales.classes;

import com.unisales.interfaces.Movivel;

public class Bicicleta extends Veiculo implements Movivel {
    private boolean eletrica;

    public Bicicleta(String modelo, int anoDeFabricacao, double preco, boolean eletrica) {
        super(modelo, anoDeFabricacao, preco);
        this.eletrica = eletrica;
    }

    public Bicicleta(String modelo, int anoDeFabricacao, boolean eletrica) {
        super(modelo, anoDeFabricacao);
        this.eletrica = eletrica;
    }

    @Override             
    public void mover() {
        System.out.println(
                "Pedalando a bicicleta: " + getModelo() + " com energia " + (eletrica ? "elétrica!" : "das pernas!"));
    }

    @Override
    public double velocidadeMaxima() {
        return eletrica ? 45.0 : 25.0;
    }

    public void exibirDetalhes() {
        System.out.println("Modelo: " + getModelo());
        System.out.println("Ano de Fabricação: " + getAnoDeFabricacao());
        System.out.println("Preço: R$" + getPreco());
        System.out.println("Tipo: " + (eletrica ? "Elétrica" : "Comum"));
        System.out.println("Velocidade Máxima: " + velocidadeMaxima() + " km/h");
        System.out.println();
    }

    public void exibirDetalhes(boolean completo) {
        if (completo) {
            exibirDetalhes();
            System.out.println("Perfeita para o meio ambiente!.");
        } else {
            exibirDetalhes();
        }
    }

    @Override
    public String getTipoCombustivel() {
        return "Nenhum (força humana ou bateria)";
    }

}
