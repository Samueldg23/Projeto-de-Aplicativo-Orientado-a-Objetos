package com.unisales.service;

import java.util.List;

import com.unisales.domain.ContaBancaria;
import com.unisales.domain.ContaCorrente;
import com.unisales.domain.ContaPoupanca;

public class OperacaoService {

    public void aplicarCicloMensal(List<ContaBancaria> contas) {
        for (ContaBancaria c : contas) {
            if (c instanceof ContaPoupanca cp) {
                double rendimento = cp.getSaldo() * cp.getTaxaRendimentoMensal();
                cp.depositar(rendimento);
            }

            if (c instanceof ContaCorrente cc) {
                double tarifa = cc.getTarifaMensal();
                cc.sacar(tarifa);
            }
        }
    }
}
