package com.unisales.interfaces;


import com.unisales.domain.ContaBancaria;

public interface Transacional {
    void depositar(double valor);
    void sacar(double valor);
    void transferir(ContaBancaria destino, double valor);
}
