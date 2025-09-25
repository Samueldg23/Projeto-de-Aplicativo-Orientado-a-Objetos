package com.unisales.classes;


public abstract class Veiculo {
    private String modelo;
    private int anoDeFabricacao;
    private double preco;
    private String tipoCombustivel;

    public Veiculo(String modelo, int anoDeFabricacao, double preco) {
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
        this.preco = preco;
    }
    public Veiculo(String modelo, int anoDeFabricacao) {
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAnoDeFabricacao() {
        return anoDeFabricacao;
    }
    public void setAnoDeFabricacao(int anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public abstract String getTipoCombustivel();

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

}
