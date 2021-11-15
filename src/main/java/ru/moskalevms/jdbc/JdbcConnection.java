package ru.moskalevms.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The type Jdbc connection.
 */
public class JdbcConnection {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcConnection.class);

    private static String jdbcURL = "jdbc:h2:~/statistics";
    private static String jdbcUsername = "sa";
    private static String jdbcPassword = "";

    /**
     * Gets connection.
     *
     * @return the connection
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            LOGGER.error("Ошибка подключения к БД {}", e.getMessage());
        }
        return connection;
    }

}
