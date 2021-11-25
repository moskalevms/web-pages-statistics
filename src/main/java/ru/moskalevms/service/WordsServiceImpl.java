package ru.moskalevms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.moskalevms.dao.UniqueWordsDao;
import ru.moskalevms.dao.UniqueWordsDaoImpl;
import ru.moskalevms.model.UniqueWords;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class WordsServiceImpl implements WordsService{

    private static final Logger LOGGER = LoggerFactory.getLogger(WordsServiceImpl.class);

    private final UniqueWordsDao uniqueWordsDao = new UniqueWordsDaoImpl();

    private final HtmlReaderService readerService = new HtmlReaderByUrlServiceImpl();

    private final UniqueWordCounterService wordCounterService = new UniqueWordCounterServiceImpl(readerService);

    @Override
    public void save() {
        Map<String, Integer> statistics = wordCounterService.getUniqueWordsStatistics();

        List<UniqueWords> uniqueWords = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : statistics.entrySet()){
              UniqueWords word = new UniqueWords();
              word.setWord(entry.getKey());
              word.setCount(String.valueOf(entry.getValue()));
              uniqueWords.add(word);
        }
        uniqueWordsDao.save(uniqueWords);
    }

    public List<UniqueWords> findAll(){
        return uniqueWordsDao.findAll();
    }

    @Override
    public List<UniqueWords> getStatistics() {
        return uniqueWordsDao.getStatistics();
    }

}
