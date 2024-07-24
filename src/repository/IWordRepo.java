package repository;

import entities.Request;
import entities.Word;

public interface IWordRepo {
    public Word lookup(String word);

    public boolean defineWord(Request request);

    public boolean drop(String word);
}