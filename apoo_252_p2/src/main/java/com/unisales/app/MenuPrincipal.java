package com.unisales.app;

import java.util.List;
import java.util.Scanner;

import com.unisales.domain.*;
import com.unisales.service.*;

public class MenuPrincipal {

    private final Scanner sc = new Scanner(System.in);
    private final ClienteService clienteService;
    private final ContaService contaService;
    private final OperacaoService operacaoService = new OperacaoService();
    private final RelatorioService relatorioService = new RelatorioService();

    public MenuPrincipal(ClienteService clienteService, ContaService contaService) {
        this.clienteService = clienteService;
        this.contaService = contaService;
    }

    public void exibirMenu() {
        int op;
        do {
            System.out.println("\n===== BANCO APP =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Atualizar Cliente");
            System.out.println("4 - Remover Cliente");
            System.out.println("5 - Cadastrar Conta");
            System.out.println("6 - Listar Contas");
            System.out.println("7 - Atualizar Conta (número/ativa)");
            System.out.println("8 - Remover Conta");
            System.out.println("9 - Depositar");
            System.out.println("10 - Sacar");
            System.out.println("11 - Transferir");
            System.out.println("12 - Aplicar Ciclo Mensal");
            System.out.println("13 - Gerar Relatório");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            op = lerInt();

            switch (op) {
                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                case 3 -> atualizarCliente();
                case 4 -> removerCliente();
                case 5 -> cadastrarConta();
                case 6 -> listarContas();
                case 7 -> atualizarConta();
                case 8 -> removerConta();
                case 9 -> depositar();
                case 10 -> sacar();
                case 11 -> transferir();
                case 12 -> aplicarCicloMensal();
                case 13 -> gerarRelatorio();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    // ===== CLIENTE =====
    private void cadastrarCliente() {
        System.out.println("\n=== CADASTRAR CLIENTE ===");
        System.out.print("Nome: "); String nome = sc.nextLine();
        System.out.print("CPF: "); String cpf = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Telefone: "); String tel = sc.nextLine();
        clienteService.adicionarCliente(new Cliente(nome, cpf, email, tel));
        System.out.println("Cliente cadastrado.");
    }

    private void listarClientes() {
        System.out.println("\n=== CLIENTES ===");
        List<Cliente> lista = clienteService.listarClientes();
        if (lista.isEmpty()) System.out.println("Nenhum cliente.");
        for (Cliente c : lista) {
            System.out.println(c.getId() + " - " + c.getNome() + " (" + c.getCpf() + ")");
        }
    }

    private void atualizarCliente() {
        listarClientes();
        System.out.print("ID do cliente: "); long id = lerLong();
        Cliente c = clienteService.buscarPorId(id);
        if (c == null) { System.out.println("Não encontrado."); return; }
        System.out.print("Novo nome ("+c.getNome()+"): "); String nome = sc.nextLine();
        System.out.print("Novo CPF ("+c.getCpf()+"): "); String cpf = sc.nextLine();
        System.out.print("Novo email ("+c.getEmail()+"): "); String email = sc.nextLine();
        System.out.print("Novo telefone ("+c.getTelefone()+"): "); String tel = sc.nextLine();
        if (!nome.isBlank()) c.setNome(nome);
        if (!cpf.isBlank()) c.setCpf(cpf);
        if (!email.isBlank()) c.setEmail(email);
        if (!tel.isBlank()) c.setTelefone(tel);
        clienteService.atualizarCliente(c);
        System.out.println("Cliente atualizado.");
    }

    private void removerCliente() {
        listarClientes();
        System.out.print("ID do cliente: "); long id = lerLong();
        clienteService.removerCliente(id);
        System.out.println("Cliente removido.");
    }

    // ===== CONTA =====
    private void cadastrarConta() {
        System.out.println("\n=== CADASTRAR CONTA ===");
        listarClientes();
        System.out.print("ID do cliente: "); long idCli = lerLong();
        Cliente cli = clienteService.buscarPorId(idCli);
        if (cli == null) { System.out.println("Cliente não encontrado."); return; }

        System.out.print("Número da conta: "); String numero = sc.nextLine();
        System.out.print("Tipo (1-Corrente, 2-Poupança): "); int tipo = lerInt();

        ContaBancaria conta = (tipo == 1)
            ? new ContaCorrente(numero, cli, 0.0, 500.0, 19.90)
            : new ContaPoupanca(numero, cli, 0.0, 0.006, 1);

        contaService.adicionarConta(conta);
        System.out.println("Conta cadastrada.");
    }

    private void listarContas() {
        System.out.println("\n=== CONTAS ===");
        List<ContaBancaria> contas = contaService.listarContas();
        if (contas.isEmpty()) System.out.println("Nenhuma conta.");
        for (ContaBancaria c : contas) {
            String cliente = (c.getCliente()!=null? c.getCliente().getNome() : "-");
            System.out.println(c.getId()+" - "+c.getTipo()+" - "+c.getNumero()+" - Cliente: "+cliente+" - Saldo: R$ "+String.format("%.2f", c.getSaldo()));
        }
    }

    private void atualizarConta() {
        listarContas();
        System.out.print("ID da conta: "); long id = lerLong();
        ContaBancaria c = contaService.buscarPorId(id);
        if (c == null) { System.out.println("Não encontrada."); return; }
        System.out.print("Novo número ("+c.getNumero()+"): "); String numero = sc.nextLine();
        System.out.print("Ativa? (1=Sim / 0=Não) atual ("+(c.isAtiva()?"Sim":"Não")+") : "); int ativa = lerInt();
        if (!numero.isBlank()) c.setNumero(numero);
        c.setAtiva(ativa == 1);
        contaService.atualizarConta(c);
        System.out.println("Conta atualizada.");
    }

    private void removerConta() {
        listarContas();
        System.out.print("ID da conta: "); long id = lerLong();
        contaService.removerConta(id);
        System.out.println("Conta removida.");
    }

    // ===== OPERAÇÕES =====
    private void depositar() {
        listarContas();
        System.out.print("ID da conta: "); long id = lerLong();
        System.out.print("Valor: "); double v = lerDouble();
        ContaBancaria c = contaService.buscarPorId(id);
        if (c == null) { System.out.println("Não encontrada."); return; }
        c.depositar(v);
        contaService.atualizarConta(c);
        System.out.println("Depósito realizado.");
    }

    private void sacar() {
        listarContas();
        System.out.print("ID da conta: "); long id = lerLong();
        System.out.print("Valor: "); double v = lerDouble();
        ContaBancaria c = contaService.buscarPorId(id);
        if (c == null) { System.out.println("Não encontrada."); return; }
        c.sacar(v);
        contaService.atualizarConta(c);
        System.out.println("Saque tentado (verifique saldo).");
    }

    private void transferir() {
        listarContas();
        System.out.print("ID origem: "); long o = lerLong();
        System.out.print("ID destino: "); long d = lerLong();
        System.out.print("Valor: "); double v = lerDouble();
        ContaBancaria origem = contaService.buscarPorId(o);
        ContaBancaria destino = contaService.buscarPorId(d);
        if (origem==null || destino==null) { System.out.println("Conta não encontrada."); return; }
        origem.transferir(destino, v);
        contaService.atualizarConta(origem);
        contaService.atualizarConta(destino);
        System.out.println("Transferência concluída (se saldo suficiente).");
    }

    private void aplicarCicloMensal() {
        List<ContaBancaria> contas = contaService.listarContas();
        operacaoService.aplicarCicloMensal(contas);
        for (ContaBancaria c : contas) contaService.atualizarConta(c);
        System.out.println("Ciclo mensal aplicado.");
    }

    private void gerarRelatorio() {
        List<ContaBancaria> contas = contaService.listarContas();
        System.out.println(relatorioService.gerarResumo(contas));
    }

    // ===== utils leitura =====
    private int lerInt() {
        while (!sc.hasNextInt()) { sc.nextLine(); System.out.print("Número: "); }
        int x = sc.nextInt(); sc.nextLine(); return x;
    }
    private long lerLong() {
        while (!sc.hasNextLong()) { sc.nextLine(); System.out.print("Número: "); }
        long x = sc.nextLong(); sc.nextLine(); return x;
    }
    private double lerDouble() {
        while (!sc.hasNextDouble()) { sc.nextLine(); System.out.print("Número: "); }
        double x = sc.nextDouble(); sc.nextLine(); return x;
    }
}
