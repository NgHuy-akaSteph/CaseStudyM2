package service;

import entities.Word;
import repository.IWordRepo;
import repository.WordRepoImpl;

public class WordServiceImpl implements IWordService {
    private final IWordRepo wordRepo = new WordRepoImpl();

    @Override
    public Word lookup(String word) {
        return wordRepo.lookup(word);
    }

    @Override
    public boolean drop(String word) {
        return wordRepo.drop(word);
    }
}