package view;

import controller.WordController;

import java.util.Scanner;

public class Dictionary {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        WordController wordController = new WordController();
        do {
            System.out.println("------# Từ điển Anh - Việt #------");
            System.out.println("1. Tra từ");
            System.out.println("2. Xóa từ");
            System.out.println("3. Thêm định nghĩa mới");
            System.out.println("4. Xuất từ điển ra file");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    wordController.lookup();
                    break;
                case 2:
                    wordController.drop();
                    break;
                case 3:
                    wordController.define();
                    break;
                case 4:
                    wordController.exportToTextFile();
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chọn đúng chức năng!");
            }
        }
        while(true);
    }
}