package ru.moskalevms.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.moskalevms.jdbc.JDBCConn;
import ru.moskalevms.model.UniqueWords;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Unique words dao.
 */
public class UniqueWordsDaoImpl implements UniqueWordsDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UniqueWordsDaoImpl.class);

    private static final String SAVE_STATISTICS = "INSERT INTO unique_words (word, count) VALUES (?,?)";

    private static final String SELECT_ALL = "SELECT * FROM unique_words";

    private static final String SELECT_BY_COUNT = "SELECT * FROM unique_words ORDER BY count DESC";

    private static final String SELECT_BY_WORD = "SELECT * FROM unique_words WHERE word = ?;";

    @Override
    public void save(List<UniqueWords> uniqueWords) {

        try (Connection connection = JDBCConn.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_STATISTICS)) {

            for (UniqueWords words : uniqueWords) {
                preparedStatement.setString(1, words.getWord());
                preparedStatement.setString(2, words.getCount());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error("Ошибка записи данных в таблицу {}", e.getMessage());
        }
    }

    @Override
    public List<UniqueWords> findAll() {
       return getWordsList(SELECT_ALL);
    }

    @Override
    public UniqueWords findByWord(String word) {

        return null;
    }

    @Override
    public List<UniqueWords> getStatistics() {
        return getWordsList(SELECT_BY_COUNT);
    }

    @Override
    public UniqueWords findByCount(int count) {
        return null;
    }

    @Override
    public void update(List<UniqueWords> uniqueWords) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void deleteAll() {

    }

    private List<UniqueWords> getWordsList(String query){

        List<UniqueWords> uniqueWordsList = new ArrayList<>();

        try (Connection connection = JDBCConn.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try( ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    UniqueWords word = new UniqueWords();
                    word.setId(rs.getLong(1));
                    word.setWord(rs.getString(2));
                    word.setCount(rs.getString(3));
                    uniqueWordsList.add(word);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Ошибка чтения данных из базы данных {} ", e.getMessage());
        }
        return uniqueWordsList;

    }

}
