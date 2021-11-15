package ru.moskalevms.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The type Create drop table.
 */
public class CreateDropTable {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateDropTable.class);

    private static final String createTableSQL = "create table unique_words (\r\n" + "  id bigserial primary key,\r\n" +
            "  word varchar(255),\r\n" + "  count varchar(255),\r\n" + " );";

    private static final String dropTableSQL = "drop table unique_words;";

    /**
     * Create table.
     *
     * @throws SQLException the sql exception
     */
    public void createTable() throws SQLException {
        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement();) {
             statement.execute(createTableSQL);
        } catch (SQLException e) {
            LOGGER.error("Ошибка создания таблицы в БД {} ", e.getMessage());
        }
    }

    /**
     * Drop table.
     *
     * @throws SQLException the sql exception
     */
    public void dropTable() throws SQLException {
        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement();) {
            statement.execute(dropTableSQL);
        } catch (SQLException e) {
            LOGGER.error("Ошибка удаления таблицы в БД {} ", e.getMessage());
        }
    }

}
