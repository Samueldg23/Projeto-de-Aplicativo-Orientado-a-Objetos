package com.unisales.app;

import com.unisales.domain.*;
import com.unisales.service.*;

public class BancoApp {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        ContaService contaService = new ContaService();

        clienteService.criarTabela();
        contaService.criarTabela();

        // só cria dados de exemplo se não houver clientes
        if (clienteService.listarClientes().isEmpty()) {
            Cliente clienteTeste = new Cliente("João da Silva", "111.222.333-44", "joao@email.com", "99999-8888");
            clienteService.adicionarCliente(clienteTeste);

            ContaCorrente cc = new ContaCorrente("001", clienteTeste, 500.0, 500.0, 19.90);
            contaService.adicionarConta(cc);

            ContaPoupanca cp = new ContaPoupanca("002", clienteTeste, 1000.0, 0.006, 5);
            contaService.adicionarConta(cp);

            System.out.println("Cliente e contas de teste criados com sucesso!");
        }

        MenuPrincipal menu = new MenuPrincipal(clienteService, contaService);
        menu.exibirMenu();
    }
}
