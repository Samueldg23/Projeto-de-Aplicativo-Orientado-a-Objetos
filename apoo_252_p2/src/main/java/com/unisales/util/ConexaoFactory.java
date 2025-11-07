package com.unisales.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    private static final String URL = "jdbc:h2:~/banco_app"; 
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao H2: " + e.getMessage());
            return null;
        }
    }
}
