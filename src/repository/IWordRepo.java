package repository;

import entities.Definition;
import entities.Word;

public interface IWordRepo {
    public Word lookup(String word);

    public void define();

    public boolean drop(String word);

    public void exportToTextFile();
}
