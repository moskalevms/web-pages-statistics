package ru.moskalevms.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * The type Unique word counter service.
 */
public class UniqueWordCounterServiceImpl implements UniqueWordCounterService{

    private final HtmlReaderService htmlReaderService;

    /**
     * Instantiates a new Unique word counter service.
     *
     * @param htmlReaderService the html reader service
     */
    public UniqueWordCounterServiceImpl(HtmlReaderService htmlReaderService) {
        this.htmlReaderService = htmlReaderService;
    }

    /**
     * Count unique words map.
     *
     * @return the map
     */
    @Override
    public Map<String, Integer> getUniqueWordsStatistics() {

        //Составные слова должны учитываться как одно слово
        String pattern = "[^\\p{L}\\p{Nd}-]+";

        String dashPattern = " - ";

        List<String> listOfWordToCount = new ArrayList<>(Arrays
                .asList(htmlReaderService.getTextWithoutPunctuation(pattern, dashPattern).split(" ")));

        Map<String, Integer> uniqueWordsMap = new HashMap<>();

        for (String word : listOfWordToCount) {
            if (uniqueWordsMap.containsKey(word)) {
                uniqueWordsMap.put(word, uniqueWordsMap.get(word) + 1);
            } else {
                uniqueWordsMap.put(word, 1);
            }
        }
        System.out.println(uniqueWordsMap);
        return uniqueWordsMap;
    }

}
