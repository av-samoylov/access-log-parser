package ru.courses.cycles;

import java.io.File;
import java.util.Scanner;

public class Cycles {
    public static void main(String[] args) {
        int validFileCount = 0;
        while (true) {
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();

            if (!fileExists || isDirectory) {
                System.out.println("Это не файл, а директория");
                continue;
            } else {
                validFileCount++;
                System.out.println("Путь указан верно. Это файл номер N" + validFileCount);
            }
        }
    }
}


