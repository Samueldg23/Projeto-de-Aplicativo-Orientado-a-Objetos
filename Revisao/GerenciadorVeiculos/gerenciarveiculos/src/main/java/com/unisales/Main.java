package com.unisales;

import java.util.ArrayList;

import com.unisales.classes.Bicicleta;
import com.unisales.classes.Carro;

public class Main {
    public static void main(String[] args) {
        System.out.println("Gerenciador de Veículos");
        Carro carro = new Carro("Toyota Corolla", 2020, 90000.0, 4);
        Carro carro2 = new Carro("Honda Civic", 2021, 95000.0, 4);
        Bicicleta bicicleta = new Bicicleta("Caloi 100", 2021, 1500.0, true);
        Bicicleta bicicleta2 = new Bicicleta("Monark", 2019, false);
        ArrayList<Object> veiculos = new ArrayList<>();
        veiculos.add(carro);
        veiculos.add(carro2);
        veiculos.add(bicicleta);

        for (int i = 0; i < veiculos.size(); i++) {
            Object obj = veiculos.get(i);
            if (obj instanceof Carro) {
                Carro c = (Carro) obj;
                c.exibirDetalhes(true);
                c.mover();
                c.velocidadeMaxima();
            } else if (obj instanceof Bicicleta) {
                Bicicleta b = (Bicicleta) obj;
                b.exibirDetalhes(true);
                b.mover();
            }
        }
        for (int i = 0; i < veiculos.size(); i++) {
            Object obj = veiculos.get(i);
            if (obj instanceof Bicicleta) {
                Bicicleta b = (Bicicleta) obj;
                b.exibirDetalhes(true);
                b.mover();
                b.velocidadeMaxima();
            }
        }

    }
}