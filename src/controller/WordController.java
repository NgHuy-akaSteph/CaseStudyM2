package controller;

import entities.Word;
import service.IWordService;
import service.WordServiceImpl;

import java.util.Scanner;

public class WordController{
    private final IWordService wordService = new WordServiceImpl();
    private final static Scanner scanner = new Scanner(System.in);
    public void lookup() {
        System.out.print("Nhập từ cần tra: ");
        String inputString = scanner.nextLine();
        Word word = wordService.lookup(inputString);
        if(word == null) {
            System.out.println("Không tìm thấy từ cần tra!");
        } else {
            System.out.println(word);
        }
    }

    public void drop() {
        System.out.print("Nhập từ cần xóa: ");
        String inputString = scanner.nextLine();
        boolean result = wordService.drop(inputString);
        if(result) {
            System.out.println( inputString +" đã bị xóa khỏi từ điển!");
        } else {
            System.out.println("Không tìm thấy từ cần xóa!");
        }
    }


}