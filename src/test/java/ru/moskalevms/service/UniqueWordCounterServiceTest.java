package ru.moskalevms.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class UniqueWordCounterServiceTest {

    private final HtmlReaderService readerService = new HtmlReaderByFileServiceImpl();

    private final UniqueWordCounterService wordCounterService = new UniqueWordCounterServiceImpl(readerService);

    @Test
    void countUniqueWordsTest() {
        int expected = 2;

        Map<String, Integer> resultMap = wordCounterService.getUniqueWordsStatistics();

        int actual = resultMap.get("EXAMPLE");

        Assertions.assertEquals(expected, actual);

    }
}