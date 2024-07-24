package service;

import entities.Word;

public interface IWordService {
    public Word getWord(String word);

    public boolean removeWord(String word);
}