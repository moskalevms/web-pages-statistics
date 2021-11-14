package ru.moskalevms.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.moskalevms.exception.ReadFromWebPageException;

import java.io.File;
import java.io.IOException;

/**
 * The type Html reader by file service.
 */
public class HtmlReaderByFileServiceImpl implements HtmlReaderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HtmlReaderByFileServiceImpl.class);

    @Override
    public String getTextWithoutPunctuation(String pattern, String dashPattern) {
        String textWithDashes = getText().replaceAll(pattern, " ").toUpperCase();
        return textWithDashes.replaceAll(dashPattern, " ");
    }

    private String getText() {
        File file = new File("./src/main/resources/index.html");
        Document document = null;
        try {
            document = Jsoup.parse(file, "UTF-8");
        } catch (IOException e) {
            LOGGER.error("Ошибка чтения данных из файла html {}", e.getMessage());
        }
        if (document != null) {
            return document.text();
        } else {
            throw new ReadFromWebPageException("Ошибка чтения данных из файла html. Код ошибки 4001.");
        }
    }
}
