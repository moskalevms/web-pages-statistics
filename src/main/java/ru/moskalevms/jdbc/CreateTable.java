package ru.moskalevms.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateTable.class);

    private static final String createTableSQL = "create table unique_words (\r\n" + "  id bigserial primary key,\r\n" +
            "  word varchar(255),\r\n" + "  count varchar(255),\r\n" + " );";

    public void createTable() throws SQLException {
        System.out.println(createTableSQL);
        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement();) {
             statement.execute(createTableSQL);
        } catch (SQLException e) {
            LOGGER.error("Ошибка создания таблицы в БД {} ", e.getMessage());
        }
    }

}
