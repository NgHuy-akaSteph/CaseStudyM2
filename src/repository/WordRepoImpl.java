package repository;

import entities.Definition;
import entities.Word;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WordRepoImpl implements IWordRepo {
    private final static Map<String, Word> dictionary = new LinkedHashMap<>();
    private final static Scanner scanner = new Scanner(System.in);
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
        Definition def18 = new Definition ("Adjective", "Tốt, hay, giỏi", "She is a good student");
        Word w7 = new Word("good", "/ɡʊd/", List.of(def18), List.of("excellent", "nice"));
        dictionary.put("address", w);
        dictionary.put("book", w1);
        dictionary.put("capital", w4);
        dictionary.put("duck", w3);
        dictionary.put("end", w5);
        dictionary.put("fit", w6);
        dictionary.put("good", w7);
        dictionary.put("season", w2);
    }

    @Override
    public Word lookup(String word) {
        return dictionary.get(word);
    }

    @Override
    public void define () {
        System.out.print("Nhập từ cần định nghĩa: ");
        String inputString = scanner.nextLine();
        boolean isExist = dictionary.containsKey(inputString);
        if(isExist) {
            System.out.println("Từ đã tồn tại! Thêm định nghĩa mới cho từ!");
            System.out.print("Loại định nghĩa (Verb/Noun/Adjective/Synonym):  ");
            String type = scanner.nextLine();
            if(type.equals("Noun") || type.equals("Verb") || type.equals("Adjective")){
                System.out.print("Nghĩa của từ: ");
                String meaning = scanner.nextLine();
                System.out.print("Ví dụ: ");
                String example = scanner.nextLine();
                Definition def = new Definition(type, meaning, example);
                List<Definition> defList = new ArrayList<>(dictionary.get(inputString).getDefinitions());
                defList.add(def);
                dictionary.get(inputString).setDefinitions(defList);
                System.out.println("Đã thêm định nghĩa mới cho từ " + inputString);
            }
            else if(type.equals("Synonym")){
                System.out.print("Từ đồng nghĩa: ");
                String synonym = scanner.nextLine();
                List<String> synonymList = new ArrayList<>(dictionary.get(inputString).getSynonyms());
                synonymList.addAll(Arrays.asList(synonym.split(",")));
                dictionary.get(inputString).setSynonyms(synonymList);
                System.out.println("Đã thêm từ đồng nghĩa cho từ " + inputString);
            }
            else {
                System.out.println("Loại từ không hợp lệ!");
            }
        }
        else{
            System.out.println("Từ chưa tồn tại! Thêm từ mới vào từ điển!");
            System.out.print("Phát âm: ");
            String pronunciation = scanner.nextLine();
            System.out.print("Loại từ: ");
            String wordType = scanner.nextLine();
            System.out.print("Nghĩa: ");
            String meaning = scanner.nextLine();
            System.out.print("Ví dụ: ");
            String example = scanner.nextLine();
            System.out.println("Các từ đồng nghĩa: ");
            String synonyms = scanner.nextLine();
            List<String> synonymList = List.of(synonyms.split(","));
            Definition def = new Definition(wordType, meaning, example);
            Word w = new Word(inputString, pronunciation, List.of(def), synonymList);
            dictionary.put(inputString, w);
            System.out.println("Từ " + inputString + " đã được thêm vào từ điển!");
        }
    }


    public boolean drop(String word) {
        if(dictionary.containsKey(word)) {
            dictionary.remove(word);
            return true;
        }
        return false;
    }

    @Override
    public void exportToTextFile() {
        System.out.println("Xuất file 10%..20%..30%..40%..50%..60%..70%..80%..90%..Hoàn thành!");
        try( FileWriter fileWriter = new FileWriter("src/view/dictionary.txt", false);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            for(Map.Entry<String, Word> entry : dictionary.entrySet()) {
                bufferedWriter.write(entry.getValue().toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}