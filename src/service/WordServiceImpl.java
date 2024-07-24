package service;

import entities.Word;
import repository.IWordRepo;
import repository.WordRepoImpl;

public class WordServiceImpl implements IWordService {
    private final IWordRepo wordRepo = new WordRepoImpl();

    @Override
    public Word getWord(String word) {
        return wordRepo.getWord(word);
    }

    @Override
    public boolean removeWord(String word) {
        return wordRepo.removeWord(word);
    }
}