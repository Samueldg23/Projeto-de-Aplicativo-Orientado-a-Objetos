package com.unisales.domain;

public class ContaCorrente extends ContaBancaria {

    private double limiteChequeEspecial; // ex.: 500.00
    private double tarifaMensal;         // ex.: 19.90

    public ContaCorrente() {
        super();
        setTipo(TipoConta.CORRENTE);
        this.limiteChequeEspecial = 500.0;
        this.tarifaMensal = 19.90;
    }

    public ContaCorrente(String numero, Cliente cliente, double saldoInicial,
                         double limiteChequeEspecial, double tarifaMensal) {
        super(numero, TipoConta.CORRENTE, cliente);
        setSaldo(saldoInicial);
        this.limiteChequeEspecial = Math.max(0.0, limiteChequeEspecial);
        this.tarifaMensal = Math.max(0.0, tarifaMensal);
    }

    @Override
    public boolean sacar(double valor) {
        if (!isAtiva() || valor <= 0) return false;
        double disponibilidade = getSaldo() + limiteChequeEspecial;
        if (valor > disponibilidade) return false;
        setSaldo(getSaldo() - valor);
        return true;
    }

    @Override
    public boolean depositar(double valor) {
        return super.depositar(valor);
    }

    public void cobrarTarifa() {
        sacar(tarifaMensal);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("=== Conta Corrente ===");
        System.out.println("Número : " + getNumero());
        System.out.println("Cliente: " + (getCliente() != null ? getCliente().getNome() : "-"));
        System.out.println("Saldo  : R$ " + getSaldo());
        System.out.println("Ativa  : " + (isAtiva() ? "Sim" : "Não"));
        System.out.println("Limite Cheque Especial: R$ " + limiteChequeEspecial);
        System.out.println("Tarifa Mensal         : R$ " + tarifaMensal);
    }

    public double getLimiteChequeEspecial() { return limiteChequeEspecial; }
    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = Math.max(0.0, limiteChequeEspecial);
    }

    public double getTarifaMensal() { return tarifaMensal; }
    public void setTarifaMensal(double tarifaMensal) {
        this.tarifaMensal = Math.max(0.0, tarifaMensal);
    }
}
