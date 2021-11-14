package ru.moskalevms.service;

import ru.moskalevms.model.UniqueWords;

import java.util.List;

public interface WordsService {

    void save();

    List<UniqueWords> findAll();

}
