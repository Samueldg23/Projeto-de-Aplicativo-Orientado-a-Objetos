package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoDAOImpl implements ProdutoDAO {
    
    @Override
    public void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS produtos (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                nome VARCHAR(100) NOT NULL,
                descricao VARCHAR(255),
                preco DECIMAL(10,2) NOT NULL,
                quantidade INTEGER NOT NULL
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
             PreparedStatement pstmt = conn.prepareStatement(sql, 
                 Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setInt(4, produto.getQuantidade());
            
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
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
}