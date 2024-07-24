package repository;

import entities.Word;

public interface IWordRepo {
    public Word getWord(String word);

    public boolean removeWord(String word);
}