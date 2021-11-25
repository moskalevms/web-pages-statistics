package ru.moskalevms.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The type Create drop table.
 */
public class DDLOperations {

    private static final Logger LOGGER = LoggerFactory.getLogger(DDLOperations.class);

    private static final String createTableSQL = "create table unique_words (\r\n" + "  id bigserial auto_increment primary key,\r\n" +
            "  word varchar(255),\r\n" + "  count varchar(255),\r\n" + ");";

    private static final String dropTableSQL = "drop table unique_words;";

    private static final String createIndex = "create index word on unique_words(word);";

    /**
     * Create table.
     *
     */
    public void createTable()  {
        executeQuery(createTableSQL, "Ошибка создания таблицы в БД ");
    }

    public void createIndex(){
        executeQuery(createIndex, "Не удалось добавить индексы в таблицу" );
    }

    /**
     * Drop table.
     *
     */
    public void dropTable() {
         executeQuery(dropTableSQL, "Ошибка удаления таблицы из БД");
    }

    private void executeQuery(String query, String errorMessage) {
        try (Connection connection = JDBCConn.getConnection();
             Statement statement = connection.createStatement();) {
            statement.execute(query);
        } catch (SQLException e) {
            LOGGER.error(errorMessage + " {} ", e.getMessage());
        }
    }

}
