package com.unisales.classes;

import com.unisales.interfaces.Movivel;

//Herda de Veiculo e implementa Movivel
public class Carro extends Veiculo implements Movivel {
    private int numeroPortas;

    public Carro(String modelo, int anoDeFabricacao, double preco, int numeroPortas) {
        super(modelo, anoDeFabricacao, preco);
        this.numeroPortas = numeroPortas;
    }
    public Carro(String modelo, int anoDeFabricacao, int numeroPortas) {
        super(modelo, anoDeFabricacao);
        this.numeroPortas = numeroPortas;
    }
    @Override
    public void mover() {
        System.out.println("Dirigindo o carro: " + getModelo() + " a toda velocidade!");
    }
    
    @Override
    public double velocidadeMaxima() {
        return 180.0;
    }
    @Override
    public String getTipoCombustivel() {
        return "Gasolina ou Etanol";
    }

    public void exibirDetalhes() {
        System.out.println("Modelo: " + getModelo());
        System.out.println("Ano de Fabricação: " + getAnoDeFabricacao());
        System.out.println("Preço: R$" + getPreco());
        System.out.println("Número de Portas: " + numeroPortas);
        System.out.println("Tipo de Combustível: " + getTipoCombustivel());
        System.out.println("Velocidade Máxima: " + velocidadeMaxima() + " km/h");
        System.out.println();
    }
    public void exibirDetalhes(boolean completo) {
        if (completo) {
            exibirDetalhes();
            System.out.println("Ideal para viagens longas.");
        } else {
            exibirDetalhes();
        }
    }
}
