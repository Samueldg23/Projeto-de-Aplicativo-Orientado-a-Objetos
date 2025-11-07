package com.unisales.service;

import java.util.List;

import com.unisales.dao.ClienteDAO;
import com.unisales.domain.Cliente;

public class ClienteService {

    private final ClienteDAO clienteDAO = new ClienteDAO();

    public void criarTabela() {
        clienteDAO.criarTabela();
    }

    public void adicionarCliente(Cliente cliente) {
        clienteDAO.inserir(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listarTodos();
    }

    public Cliente buscarPorId(Long id) {
        return clienteDAO.buscarPorId(id);
    }

    public void atualizarCliente(Cliente cliente) {
        clienteDAO.atualizar(cliente);
    }

    public void removerCliente(Long id) {
        clienteDAO.deletar(id);
    }
}
