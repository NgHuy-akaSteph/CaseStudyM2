package entities;

public class Definition {
    String type;
    String meaning;
    String example;

    public Definition(String type, String meaning, String example) {
        this.type = type;
        this.meaning = meaning;
        this.example = example;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    //To String method
    @Override
    public String toString() {
        return "- " + meaning + "\n" +
                "= " + example + "\n";
    }
}
