package ru.moskalevms;

import ru.moskalevms.jdbc.CreateDropTable;
import ru.moskalevms.service.*;

import java.io.IOException;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws IOException, SQLException {

        runner();

    }

    private static void runner() throws SQLException {
        CreateDropTable createDropTable = new CreateDropTable();
        createDropTable.createTable();

        HtmlReaderService readerService = new HtmlReaderByUrlServiceImpl();
        UniqueWordCounterService wordCounterService = new UniqueWordCounterServiceImpl(readerService);
        wordCounterService.getUniqueWordsStatistics();

        WordsService wordsService = new WordsServiceImpl();
        //   wordsService.save();
        createDropTable.dropTable();
    }
}
