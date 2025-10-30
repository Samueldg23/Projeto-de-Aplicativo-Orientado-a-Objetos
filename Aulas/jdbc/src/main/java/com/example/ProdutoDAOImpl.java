package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOImpl implements ProdutoDAO {

    @Override
    public void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS produtos (
                id IDENTITY PRIMARY KEY,
                nome VARCHAR(100) NOT NULL,
                descricao VARCHAR(255),
                preco DOUBLE NOT NULL,
                quantidade INT NOT NULL
            )
            """;

        try (Connection conn = HikariCPConfig.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inserir(Produto produto) {
        String sql = """
            INSERT INTO produtos (nome, descricao, preco, quantidade)
            VALUES (?, ?, ?, ?)
            """;

        try (Connection conn = HikariCPConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setInt(4, produto.getQuantidade());

            int affected = pstmt.executeUpdate();
            if (affected > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        produto.setId(rs.getLong(1));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Produto buscarPorId(Long id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        Produto produto = null;

        try (Connection conn = HikariCPConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    produto = new Produto();
                    produto.setId(rs.getLong("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setPreco(rs.getDouble("preco"));
                    produto.setQuantidade(rs.getInt("quantidade"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produto;
    }

    @Override
    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (Connection conn = HikariCPConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                produtos.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }

    @Override
    public void atualizar(Produto produto) {
        String sql = """
            UPDATE produtos 
            SET nome = ?, descricao = ?, preco = ?, quantidade = ? 
            WHERE id = ?
            """;

        try (Connection conn = HikariCPConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setInt(4, produto.getQuantidade());
            pstmt.setLong(5, produto.getId());

            int linhas = pstmt.executeUpdate();
            System.out.println(linhas + " linha(s) atualizada(s).");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM produtos WHERE id = ?";

        try (Connection conn = HikariCPConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            int linhas = pstmt.executeUpdate();
            System.out.println(linhas + " linha(s) deletada(s).");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
