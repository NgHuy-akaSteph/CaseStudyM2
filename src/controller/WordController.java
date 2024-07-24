package controller;

import entities.Word;
import service.IWordService;
import service.WordServiceImpl;

import java.util.Scanner;

public class WordController{
    private final IWordService wordService = new WordServiceImpl();
    private final static Scanner scanner = new Scanner(System.in);
    public void searchWord() {
        System.out.print("Nhập từ cần tra: ");
        String inputString = scanner.nextLine();
        Word word = wordService.getWord(inputString);
        if(word == null) {
            System.out.println("Không tìm thấy từ cần tra!");
        } else {
            System.out.println(word);
        }
    }

    public void removeWord() {
        System.out.print("Nhập từ cần xóa: ");
        String inputString = scanner.nextLine();
        boolean result = wordService.removeWord(inputString);
        if(result) {
            System.out.println( inputString +" đã bị xóa khỏi từ điển!");
        } else {
            System.out.println("Không tìm thấy từ cần xóa!");
        }
    }


}