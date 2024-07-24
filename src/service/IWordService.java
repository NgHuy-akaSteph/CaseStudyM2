package service;

import entities.Word;

public interface IWordService {
    public Word lookup(String word);

    public boolean drop(String word);
}