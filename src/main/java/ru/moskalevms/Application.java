package ru.moskalevms;

import ru.moskalevms.jdbc.CreateTable;
import ru.moskalevms.service.HtmlReaderByUrlServiceImpl;
import ru.moskalevms.service.HtmlReaderService;
import ru.moskalevms.service.UniqueWordCounterService;
import ru.moskalevms.service.UniqueWordCounterServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws IOException, SQLException {

        CreateTable createTable = new CreateTable();
        createTable.createTable();

      //  HtmlReaderService readerService = new HtmlReaderByUrlServiceImpl();
      //  UniqueWordCounterService wordCounterService = new UniqueWordCounterServiceImpl(readerService);
      //  wordCounterService.getUniqueWordsStatistics();

    }
}
