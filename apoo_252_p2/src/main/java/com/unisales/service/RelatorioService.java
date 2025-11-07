package com.unisales.service;

import java.util.List;
import java.util.StringJoiner;

import com.unisales.domain.ContaBancaria;
import com.unisales.domain.Cliente;

public class RelatorioService {

    public String gerarResumo(List<ContaBancaria> contas) {
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("===== RELATÓRIO DE CONTAS =====");
        if (contas == null || contas.isEmpty()) {
            sj.add("Nenhuma conta cadastrada.");
        } else {
            for (ContaBancaria c : contas) {
                Cliente cli = c.getCliente();
                String nomeCliente = (cli != null) ? cli.getNome() : "Sem cliente";
                sj.add(c.getTipo() + " - Conta: " + c.getNumero() +
                       " - Cliente: " + nomeCliente +
                       " - Saldo: R$ " + String.format("%.2f", c.getSaldo()));
            }
        }
        return sj.toString();
    }
}
