package com.unisales;

import com.unisales.classes.subclasses.Filme;
import com.unisales.classes.subclasses.Livro;

public class Main {
    public static void main(String[] args) {
        Livro livro = new Livro("1984", 1949, 9.5, 328);
        Livro livro2 = new Livro("Entendendo Algoritmos", 2020, 150);
        Filme filme = new Filme("Inception", 2010, 8.8, 148);
        Filme filme2 = new Filme("The Matrix", 1999, 136);

        livro.exibirInfo();
        livro.exibirInfo(true); 
        livro.reproduzir();
        System.out.println("Duração estimada do livro: " + livro.getDuracao() + " minutos\n");
        livro2.exibirInfo();
        livro2.reproduzir();
        System.out.println("Duração estimada do livro: " + livro2.getDuracao() + " minutos\n");
        filme.exibirInfo();
        filme.exibirInfo(true);
        filme.reproduzir();
        System.out.println("Duração do filme: " + filme.getDuracao() + " minutos\n");
        filme2.exibirInfo();
        filme2.reproduzir();
        System.out.println("Duração do filme: " + filme2.getDuracao() + " minutos\n");

        double duracaoTotal = livro.getDuracao() + livro2.getDuracao() + filme.getDuracao() + filme2.getDuracao();
        System.out.println("Duração total de todas as mídias: " + duracaoTotal + " minutos");
    }
}

/*
 Classe Principal (Main):
Crie uma classe Main com método main.
Instancie pelo menos um Livro e um Filme usando construtores diferentes (demonstrando sobrecarga).
Chame métodos como exibirInfo() (versões sobrecarregadas), reproduzir() e getDuracao() para cada instância.
Exiba a soma das durações de todas as mídias usando um loop ou lista (opcional: use um vetor ou uma ArrayList para armazenar as mídias e iterar sobre elas).

 */