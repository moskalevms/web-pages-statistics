package ru.moskalevms.service;

import java.util.Map;

/**
 * The interface Unique word counter service.
 */
public interface UniqueWordCounterService {

    /**
     * Gets unique words.
     *
     * @return the unique words
     */
    Map<String, Integer> getUniqueWordsStatistics();

}
