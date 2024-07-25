package entities;

import java.util.List;

public class Word {
    String keyword;
    String pronunciation;
    List<Definition> definitions;
    List<String> synonyms;

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

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public Word(String keyword, String pronunciation, List<Definition> definitions, List<String> synonyms) {
        this.keyword = keyword;
        this.pronunciation = pronunciation;
        this.definitions = definitions;
        this.synonyms = synonyms;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@").append(keyword).append(pronunciation).append("\n");
        boolean hasNoun = false, hasVerb = false, hasAdjective = false;
        for(Definition definition : definitions) {
            if(definition.getType().equals("Noun")) {
                hasNoun = true;
            }
            if(definition.getType().equals("Verb")) {
                hasVerb = true;
            }
            if(definition.getType().equals("Adjective")) {
                hasAdjective = true;
            }
        }
        if(hasNoun) {
            stringBuilder.append("* Danh từ : \n");
            for(Definition definition : definitions) {
                if(definition.getType().equals("Noun")) {
                    stringBuilder.append(definition);
                }
            }
        }
        if(hasVerb) {
            stringBuilder.append("* Động từ : \n");
            for(Definition definition : definitions) {
                if(definition.getType().equals("Verb")) {
                    stringBuilder.append(definition);
                }
            }
        }
        if(hasAdjective) {
            stringBuilder.append("* Tính từ : \n");
            for(Definition definition : definitions) {
                if(definition.getType().equals("Adjective")) {
                    stringBuilder.append(definition);
                }
            }
        }
        stringBuilder.append("Từ đồng nghĩa : \n");
        for(String synonym : synonyms) {
            stringBuilder.append("- ").append(synonym).append("\n");
        }
        return stringBuilder.toString();
    }

}
