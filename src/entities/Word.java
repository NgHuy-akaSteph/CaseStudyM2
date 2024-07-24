package entities;

import java.util.List;

public class Word {
    String keyword;
    String pronunciation;
    List<Definition> definitions;
    List<String> synonymous;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definition> definitions) {
        this.definitions = definitions;
    }

    public List<String> getSynonymous() {
        return synonymous;
    }

    public void setSynonymous(List<String> synonymous) {
        this.synonymous = synonymous;
    }

    public Word(String keyword, String pronunciation, List<Definition> definitions, List<String> synonymous) {
        this.keyword = keyword;
        this.pronunciation = pronunciation;
        this.definitions = definitions;
        this.synonymous = synonymous;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@").append(keyword).append(" /").append(pronunciation).append("/\n");
        stringBuilder.append("* Danh từ : \n");
        for(Definition definition : definitions) {
            if(definition.getType().equals("Noun")) {
                stringBuilder.append(definition);
            }
        }
        stringBuilder.append("* Động từ : \n");
        for(Definition definition : definitions) {
            if(definition.getType().equals("Verb")) {
                stringBuilder.append(definition);
            }
        }
        stringBuilder.append("* Tính từ : \n");
        for(Definition definition : definitions) {
            if(definition.getType().equals("Adjective")) {
                stringBuilder.append(definition);
            }
        }
        stringBuilder.append("Từ đồng nghĩa : \n");
        for(String synonym : synonymous) {
            stringBuilder.append("- ").append(synonym).append("\n");
        }
        return stringBuilder.toString();
    }

}
