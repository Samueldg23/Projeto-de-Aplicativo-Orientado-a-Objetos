package com.unisales.domain;

public abstract class ContaBancaria {
    private Long id;
    private String numero;
    private double saldo;
    private boolean ativa;
    private TipoConta tipo; // CORRENTE ou POUPANCA
    private Cliente cliente;

    public ContaBancaria() {
        this.ativa = true;
        this.saldo = 0.0;
    }

    public ContaBancaria(String numero, TipoConta tipo, Cliente cliente) {
        this();
        this.numero = numero;
        this.tipo = tipo;
        this.cliente = cliente;
    }

    public boolean depositar(double valor) {
        if (!ativa || valor <= 0)
            return false;
        saldo += valor;
        return true;
    }

    public boolean sacar(double valor) {
        if (!ativa || valor <= 0 || valor > saldo)
            return false;
        saldo -= valor;
        return true;
    }

    public boolean transferir(ContaBancaria destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public abstract void exibirInformacoes();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
