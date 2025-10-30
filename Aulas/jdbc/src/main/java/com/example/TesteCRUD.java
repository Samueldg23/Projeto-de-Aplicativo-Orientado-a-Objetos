package com.example;

public class TesteCRUD {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAOImpl();
        
        // Criar tabela
        dao.criarTabela();
        
        // Inserir produtos
        Produto p1 = new Produto("Notebook", "Dell Inspiron 15", 2500.00, 10);
        Produto p2 = new Produto("Mouse", "Mouse sem fio", 89.90, 50);
        
        dao.inserir(p1);
        dao.inserir(p2);
        
        // Listar todos
        System.out.println("=== TODOS OS PRODUTOS ===");
        dao.listarTodos().forEach(System.out::println);
        
        // Buscar por ID
        System.out.println("\n=== BUSCAR POR ID ===");
        Produto encontrado = dao.buscarPorId(p1.getId());
        System.out.println(encontrado);
        
        // Atualizar
        System.out.println("\n=== ATUALIZAR ===");
        encontrado.setPreco(2300.00);
        dao.atualizar(encontrado);
        
        // Deletar
        System.out.println("\n=== DELETAR ===");
        dao.deletar(p2.getId());
        
        // Listar após operações
        System.out.println("\n=== PRODUTOS FINAIS ===");
        dao.listarTodos().forEach(System.out::println);
    }
}