package ru.moskalevms.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.moskalevms.jdbc.JdbcConnection;
import ru.moskalevms.model.UniqueWords;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * The type Unique words dao.
 */
public class UniqueWordsDaoImpl implements UniqueWordsDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UniqueWordsDaoImpl.class);

    private static final String SAVE_STATISTICS = "INSERT INTO unique_words (id, word, count) VALUES (?,?,?)";

    @Override
    public void save(List<UniqueWords> uniqueWords) {

        try (Connection connection = JdbcConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_STATISTICS)) {

            for (UniqueWords words : uniqueWords) {
                preparedStatement.setLong(1, words.getId());
                preparedStatement.setString(2, words.getWord());
                preparedStatement.setString(3, words.getCount());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error("Ошибка записи данных в таблицу {}", e.getMessage());
        }

    }
}
