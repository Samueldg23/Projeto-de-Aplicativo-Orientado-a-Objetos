package com.unisales.domain;

public class ContaPoupanca extends ContaBancaria {

    private double taxaRendimentoMensal; // ex.: 0.006 (=0,6% a.m.)
    private int diaAniversario;          // 1..31

    public ContaPoupanca() {
        super();
        setTipo(TipoConta.POUPANCA);
        this.taxaRendimentoMensal = 0.006;
        this.diaAniversario = 1;
    }

    public ContaPoupanca(String numero, Cliente cliente, double saldoInicial,
                         double taxaRendimentoMensal, int diaAniversario) {
        super(numero, TipoConta.POUPANCA, cliente);
        setSaldo(saldoInicial);
        this.taxaRendimentoMensal = Math.max(0.0, taxaRendimentoMensal);
        this.diaAniversario = (diaAniversario < 1 || diaAniversario > 31) ? 1 : diaAniversario;
    }

    public void render() {
        double rendimento = getSaldo() * taxaRendimentoMensal;
        depositar(rendimento);
    }

    @Override
    public boolean depositar(double valor) {
        return super.depositar(valor);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("=== Conta Poupança ===");
        System.out.println("Número : " + getNumero());
        System.out.println("Cliente: " + (getCliente() != null ? getCliente().getNome() : "-"));
        System.out.println("Saldo  : R$ " + getSaldo());
        System.out.println("Ativa  : " + (isAtiva() ? "Sim" : "Não"));
        System.out.println("Taxa Rendimento Mensal: " + taxaRendimentoMensal);
        System.out.println("Dia de Aniversário    : " + diaAniversario);
    }

    public double getTaxaRendimentoMensal() { return taxaRendimentoMensal; }
    public void setTaxaRendimentoMensal(double taxaRendimentoMensal) {
        this.taxaRendimentoMensal = Math.max(0.0, taxaRendimentoMensal);
    }

    public int getDiaAniversario() { return diaAniversario; }
    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = (diaAniversario < 1 || diaAniversario > 31) ? 1 : diaAniversario;
    }
}
