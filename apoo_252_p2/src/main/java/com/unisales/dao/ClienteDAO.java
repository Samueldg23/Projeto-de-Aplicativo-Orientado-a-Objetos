package com.unisales.dao;

import com.unisales.domain.Cliente;
import com.unisales.util.ConexaoFactory;
import java.sql.*;
import java.util.*;

public class ClienteDAO {

    public void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS cliente (
              id IDENTITY PRIMARY KEY,
              nome VARCHAR(100) NOT NULL,
              cpf VARCHAR(14) NOT NULL,
              email VARCHAR(100),
              telefone VARCHAR(20)
            )
            """;
        try (Connection conn = ConexaoFactory.getConexao();
             Statement st = conn.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public Long inserir(Cliente c) {
        String sql = "INSERT INTO cliente (nome, cpf, email, telefone) VALUES (?,?,?,?)";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getTelefone());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                long id = rs.getLong(1);
                c.setId(id);
                return id;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public List<Cliente> listarTodos() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente ORDER BY id";
        try (Connection conn = ConexaoFactory.getConexao();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getLong("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                lista.add(c);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public Cliente buscarPorId(Long id) {
        String sql = "SELECT * FROM cliente WHERE id=?";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getLong("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                return c;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public void atualizar(Cliente c) {
        String sql = "UPDATE cliente SET nome=?, cpf=?, email=?, telefone=? WHERE id=?";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getTelefone());
            ps.setLong(5, c.getId());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void deletar(Long id) {
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM cliente WHERE id=?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public long contar() {
        try (Connection conn = ConexaoFactory.getConexao();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM cliente")) {
            return rs.next() ? rs.getLong(1) : 0L;
        } catch (SQLException e) { e.printStackTrace(); }
        return 0L;
    }
}
