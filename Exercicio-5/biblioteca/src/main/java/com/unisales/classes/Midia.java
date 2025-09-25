package com.unisales.classes;

public class Midia {
    private String titulo;
    private int anoLancamento;
    private double classificacao; 

    public Midia(String titulo, int anoLancamento) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.classificacao = 0.0;
    }

    public Midia(String titulo, int anoLancamento, double classificacao) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.classificacao = classificacao;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public double getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(double classificacao) {
        this.classificacao = classificacao;
    }
    public String getTipo() {
        return "Mídia Genérica";
    }
}


/*
Atributos privados: String titulo, int anoLancamento, double classificacao (nota de 0 a 10).
Construtor: Sobrecarregue o construtor para aceitar apenas titulo e anoLancamento, ou todos os três atributos.
Métodos getters e setters para todos os atributos (encapsulamento).
Método abstrato: String getTipo() para ser implementado pelas subclasses.
 */