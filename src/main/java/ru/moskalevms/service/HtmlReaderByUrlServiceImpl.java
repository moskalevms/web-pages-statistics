package ru.moskalevms.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.moskalevms.exception.ReadFromWebPageException;

import java.io.IOException;

/**
 * The type Html reader by url service.
 */
public class HtmlReaderByUrlServiceImpl implements HtmlReaderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HtmlReaderByUrlServiceImpl.class);

    private static final String URL = "https://www.simbirsoft.com/";

    @Override
    public String getTextWithoutPunctuation(String pattern, String dashPattern) {
        String textWithDashes = getText().replaceAll(pattern, " ").toUpperCase();
        return textWithDashes.replaceAll(dashPattern, " ");
    }

    private String getText() {
        Connection connection = Jsoup.connect(URL);
        connection.userAgent("Chrome/81.0.4044.138");
        Document document = null;
        try {
            document = connection.get();
        } catch (IOException e) {
            LOGGER.error("Ошибка чтения страницы {}", e.getMessage());
        }
        if (document != null) {
            return document.text();
        } else {
            throw new ReadFromWebPageException("Ошибка чтения текста со страницы. Код ошибки 4002.");
        }
    }



}
