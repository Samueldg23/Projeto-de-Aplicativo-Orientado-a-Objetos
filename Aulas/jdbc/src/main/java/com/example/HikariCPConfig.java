package com.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class HikariCPConfig {
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();

        // Banco H2 em memória (não precisa criar nada no disco)
        config.setJdbcUrl("jdbc:h2:mem:produtosdb;DB_CLOSE_DELAY=-1");
        config.setUsername("sa");
        config.setPassword("");
        config.setDriverClassName("org.h2.Driver");

        // Parâmetros do pool
        config.setMaximumPoolSize(5);
        config.setMinimumIdle(2);
        config.setIdleTimeout(30000);
        config.setConnectionTimeout(30000);
        config.setMaxLifetime(1800000);

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
