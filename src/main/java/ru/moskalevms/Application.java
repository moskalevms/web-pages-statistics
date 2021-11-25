package ru.moskalevms;

import ru.moskalevms.jdbc.DDLOperations;
import ru.moskalevms.service.HtmlReaderByUrlServiceImpl;
import ru.moskalevms.service.HtmlReaderService;
import ru.moskalevms.service.UniqueWordCounterService;

import ru.moskalevms.service.UniqueWordCounterServiceImpl;
import ru.moskalevms.service.WordsService;
import ru.moskalevms.service.WordsServiceImpl;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws  SQLException {
        runner();
    }

    private static void runner() throws SQLException {
        DDLOperations ddlOperations = new DDLOperations();
        ddlOperations.createTable();
        ddlOperations.createIndex();

        HtmlReaderService readerService = new HtmlReaderByUrlServiceImpl();
        UniqueWordCounterService wordCounterService = new UniqueWordCounterServiceImpl(readerService);
        wordCounterService.getUniqueWordsStatistics();

        WordsService wordsService = new WordsServiceImpl();
        wordsService.save();
        System.out.println(wordsService.findAll().toString());
        System.out.println(wordsService.getStatistics().toString());
        ddlOperations.dropTable();
    }
}
