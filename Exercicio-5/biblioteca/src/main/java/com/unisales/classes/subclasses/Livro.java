package com.unisales.classes.subclasses;

import com.unisales.classes.Midia;
import com.unisales.interfaces.Reproduzivel;

public class Livro extends Midia implements Reproduzivel {
    private int numeroPaginas;

    public Livro(String titulo, int anoLancamento, double classificacao, int numeroPaginas) {
        super(titulo, anoLancamento, classificacao);
        this.numeroPaginas = numeroPaginas;
    }

    public Livro(String titulo, int anoLancamento, int numeroPaginas) {
        super(titulo, anoLancamento);
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public void reproduzir() {
        System.out.println("Lendo o livro: " + getTitulo());
    }

    @Override
    public double getDuracao() {
        return numeroPaginas * 0.5; // Estimativa de duração em minutos
    }
    @Override
    public void exibirInfo() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Ano de Lançamento: " + getAnoLancamento());
        System.out.println("Classificação: " + getClassificacao());
        System.out.println("Número de Páginas: " + numeroPaginas);
    }

    @Override
    public void exibirInfo(boolean detalhado) {
        if (detalhado) {
            System.out.println("Recomendado para leitores ávidos!");
        }
    }
}

/*
 Livro: Herda de Midia e implementa Reproduzivel.
Atributo adicional privado: int numeroPaginas.
Construtor: Use super() para chamar o construtor da classe base e inicialize numeroPaginas.
Implemente reproduzir(): Imprima "Lendo o livro: [titulo]".
Implemente getDuracao(): Calcule uma duração estimada como numeroPaginas * 0.5 minutos (assumindo 2 páginas por minuto).
Sobrecarga: Crie um método sobrecarregado exibirInfo() – uma versão sem parâmetros que imprime todos os atributos, e outra com um parâmetro booleano detalhado que, se true, inclui uma mensagem extra como "Recomendado para leitores ávidos!".
 */