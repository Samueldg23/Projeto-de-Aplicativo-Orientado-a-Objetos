package com.unisales.service;

import java.util.List;

import com.unisales.dao.ContaDAO;
import com.unisales.domain.ContaBancaria;

public class ContaService {

    private final ContaDAO contaDAO = new ContaDAO();

    public void criarTabela() {
        contaDAO.criarTabela();
    }

    public void adicionarConta(ContaBancaria conta) {
        contaDAO.inserir(conta);
    }

    public List<ContaBancaria> listarContas() {
        return contaDAO.listarTodos();
    }

    public ContaBancaria buscarPorId(Long id) {
        return contaDAO.buscarPorId(id);
    }

    public void atualizarConta(ContaBancaria conta) {
        contaDAO.atualizar(conta);
    }

    public void removerConta(Long id) {
        contaDAO.deletar(id);
    }
}
