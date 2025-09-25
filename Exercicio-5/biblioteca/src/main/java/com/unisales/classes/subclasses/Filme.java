package com.unisales.classes.subclasses;

import com.unisales.classes.Midia;
import com.unisales.interfaces.Reproduzivel;

public class Filme extends Midia implements Reproduzivel{
    private int duracaoMinutos;
    public Filme(String titulo, int anoLancamento, double classificacao, int duracaoMinutos) {
        super(titulo, anoLancamento, classificacao);
        this.duracaoMinutos = duracaoMinutos;
    }
    public Filme(String titulo, int anoLancamento, int duracaoMinutos) {
        super(titulo, anoLancamento);
        this.duracaoMinutos = duracaoMinutos;
    }
    @Override
    public void reproduzir() {
        System.out.println("Assistindo o filme: " + getTitulo());
    }
    @Override
    public double getDuracao() {
        return duracaoMinutos;
    }
    @Override
    public void exibirInfo() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Ano de Lançamento: " + getAnoLancamento());
        System.out.println("Classificação: " + getClassificacao());
        System.out.println("Duração (minutos): " + duracaoMinutos);
    }
    @Override
    public void exibirInfo(boolean detalhado) {
        if (detalhado) {
            System.out.println("Ótimo para uma sessão de cinema!");
        }
    }
}

/*
Filme: Herda de Midia e implementa Reproduzivel.
Atributo adicional privado: int duracaoMinutos.
Construtor: Use super() e inicialize duracaoMinutos.
Implemente reproduzir(): Imprima "Assistindo o filme: [titulo]".
Implemente getDuracao(): Retorne simplesmente duracaoMinutos.
Sobrecarga: Similar ao Livro, crie exibirInfo() sobrecarregado, com a versão detalhada adicionando "Ótimo para uma sessão de cinema!".
 */
