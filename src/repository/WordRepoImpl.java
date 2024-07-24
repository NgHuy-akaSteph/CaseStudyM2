package repository;

import entities.Definition;
import entities.Word;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordRepoImpl implements IWordRepo {
    private final static Map<String, Word> dictionary = new LinkedHashMap<>();

    static{
        Definition def1 = new Definition("Noun", "Địa chỉ", "This is my address");
        Definition def2 = new Definition("Verb", "Chỉ đường", "Can you address me to the nearest gas station?");
        Definition def3 = new Definition("Verb", "Giải quyết", "We need to address this problem");
        Word w = new Word("address", "/əˈdres/", List.of(def1, def2, def3), List.of("location", "direction", "solve"));
        Definition def4 = new Definition("Noun", "quyển sách", "This is a book");
        Definition def5 = new Definition("Verb", "đặt chỗ, đặt mua", "I have booked a ticket");
        Word w1 = new Word("book", "/bʊk/", List.of(def4, def5), List.of("novel", "textbook"));
        Definition def6 = new Definition("Noun", "Mùa trong năm", "Autumn is my favorite season");
        Definition def7 = new Definition("Verb", "Thêm gia vị", "Season the soup with salt and pepper");
        Word w2 = new Word("season", "/ˈsiː.zən/", List.of(def6, def7), List.of("period", "flavor"));
        Definition def8 = new Definition("Noun", "Con vịt", "This is a duck");
        Definition def9 = new Definition("Verb", "Nướng", "I am going to duck the meat");
        Definition def10 = new Definition ("Verb", "Ngụp lặn", "When he saw them coming, he ducked into a doorway");
        Word w3 = new Word("duck", "/dʌk/", List.of(def8, def9, def10), List.of("bird", "avoid"));
        Definition def11 = new Definition("Noun", "Thủ đô", "Hanoi is the capital of Vietnam");
        Definition def12 = new Definition ("Noun", "Tiền vốn", "The company has a capital of 1 million dollars");
        Definition def13 = new Definition("Adjective", "Chủ yếu, cơ bản", "The capital market is closely watched by investors and analysts.");
        Word w4 = new Word("capital", "/ˈkæp.ɪ.təl/", List.of(def11, def12, def13), List.of("money", "city"));
        Definition def14 = new Definition("Noun", "Giới hạn, sự kết thúc", "The end of the school year marks the close of the academic season");
        Definition def15 = new Definition("Verb", "Kết thúc, chấm dứt", "The conference end with a speech by the president");
        Word w5 = new Word("end", "/end/", List.of(def14, def15), List.of("finish", "conclusion"));
        Definition def16 = new Definition("Verb", "Hợp, vừa", "The key fits the lock perfectly");
        Definition def17 = new Definition ("Adjective", "Thích hợp, phù hợp", "The dress is a perfect fit");
        Word w6 = new Word("fit", "/fɪt/", List.of(def16, def17), List.of("suitable", "match"));
        dictionary.put("address", w);
        dictionary.put("book", w1);
        dictionary.put("capital", w4);
        dictionary.put("duck", w3);
        dictionary.put("end", w5);
        dictionary.put("fit", w6);
        dictionary.put("season", w2);
    }

    @Override
    public Word getWord(String word) {
        return dictionary.get(word);
    }

    public boolean removeWord(String word) {
        if(dictionary.containsKey(word)) {
            dictionary.remove(word);
            return true;
        }
        return false;
    }
}