package com.unisales.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    private List<ContaBancaria> contas;

    public Cliente() {
        this.contas = new ArrayList<>();
    }

    public Cliente(String nome, String cpf, String email, String telefone) {
        this();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public void adicionarConta(ContaBancaria conta) {
        if (conta != null) {
            contas.add(conta);
            conta.setCliente(this);
        }
    }

    public void removerConta(ContaBancaria conta) {
        if (conta != null) {
            contas.remove(conta);
            if (conta.getCliente() == this) {
                conta.setCliente(null);
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }

    public void setContas(List<ContaBancaria> contas) {
        this.contas = contas;
    }
}
