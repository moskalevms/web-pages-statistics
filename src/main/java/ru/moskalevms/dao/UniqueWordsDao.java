package ru.moskalevms.dao;

import ru.moskalevms.model.UniqueWords;

import java.util.List;

/**
 * The interface Unique words dao.
 */
public interface UniqueWordsDao {

    /**
     * Save.
     *
     * @param uniqueWords the unique words
     */
    void save(List<UniqueWords> uniqueWords);

}
