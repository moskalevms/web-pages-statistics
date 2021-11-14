package ru.moskalevms.service;

/**
 * The interface Html reader service.
 */
public interface HtmlReaderService {

    /**
     * Gets text without punctuation.
     *
     * @param pattern     the pattern
     * @param dashPattern the dash pattern
     * @return the text without punctuation
     */
    String getTextWithoutPunctuation(String pattern, String dashPattern);

}
