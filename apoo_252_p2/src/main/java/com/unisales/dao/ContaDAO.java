package com.unisales.dao;

import com.unisales.domain.*;
import com.unisales.util.ConexaoFactory;
import java.sql.*;
import java.util.*;

public class ContaDAO {

    private final ClienteDAO clienteDAO = new ClienteDAO();

    public void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS conta (
              id IDENTITY PRIMARY KEY,
              numero VARCHAR(20) NOT NULL,
              saldo DOUBLE NOT NULL,
              ativa BOOLEAN NOT NULL,
              tipo VARCHAR(20) NOT NULL,
              cliente_id BIGINT,
              FOREIGN KEY (cliente_id) REFERENCES cliente(id)
            )
            """;
        try (Connection conn = ConexaoFactory.getConexao();
             Statement st = conn.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void inserir(ContaBancaria conta) {
        String sql = "INSERT INTO conta (numero, saldo, ativa, tipo, cliente_id) VALUES (?,?,?,?,?)";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, conta.getNumero());
            ps.setDouble(2, conta.getSaldo());
            ps.setBoolean(3, conta.isAtiva());
            ps.setString(4, conta.getTipo().name());
            ps.setObject(5, conta.getCliente() != null ? conta.getCliente().getId() : null); // aceita null
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<ContaBancaria> listarTodos() {
        List<ContaBancaria> lista = new ArrayList<>();
        String sql = "SELECT * FROM conta ORDER BY id";
        try (Connection conn = ConexaoFactory.getConexao();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(mapearConta(rs));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public ContaBancaria buscarPorId(Long id) {
        String sql = "SELECT * FROM conta WHERE id=?";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next() ? mapearConta(rs) : null;
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public void atualizar(ContaBancaria conta) {
        String sql = "UPDATE conta SET numero=?, saldo=?, ativa=?, tipo=?, cliente_id=? WHERE id=?";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, conta.getNumero());
            ps.setDouble(2, conta.getSaldo());
            ps.setBoolean(3, conta.isAtiva());
            ps.setString(4, conta.getTipo().name());
            ps.setObject(5, conta.getCliente() != null ? conta.getCliente().getId() : null);
            ps.setLong(6, conta.getId());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void deletar(Long id) {
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM conta WHERE id=?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private ContaBancaria mapearConta(ResultSet rs) throws SQLException {
        String tipo = rs.getString("tipo");
        ContaBancaria conta = "CORRENTE".equalsIgnoreCase(tipo) ? new ContaCorrente() : new ContaPoupanca();

        conta.setId(rs.getLong("id"));
        conta.setNumero(rs.getString("numero"));
        conta.setSaldo(rs.getDouble("saldo"));
        conta.setAtiva(rs.getBoolean("ativa"));
        conta.setTipo(TipoConta.valueOf(tipo));

        Long clienteId = (Long) rs.getObject("cliente_id");
        if (clienteId != null) {
            conta.setCliente(clienteDAO.buscarPorId(clienteId)); // agora mostra nome do cliente nas listagens
        }
        return conta;
    }
}
