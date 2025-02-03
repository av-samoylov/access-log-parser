package ru.courses.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLineReader {
    public static void main(String[] args) {
        String path = "C:\\Users\\Admin\\Downloads\\access.log";
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            System.out.println("Указанный путь не существует или не является файлом.");
            return;
        }

        int totalLines = 0;
        int maxLineLength = 0;
        int minLineLength = Integer.MAX_VALUE;

        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                totalLines++;
                int lineLength = line.length();
                if (lineLength > 1024) {
                    throw new LineTooLongException("Строка превышает 1024 символа: " + lineLength);
                }
                if (lineLength > maxLineLength) {
                    maxLineLength = lineLength;
                }
                if (lineLength < minLineLength) {
                    minLineLength = lineLength;
                }
            }
        } catch (LineTooLongException e) {
            System.out.println(e.getMessage());
            return;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Всего строк: " + totalLines);
        System.out.println("Максимальная длина строки: " + maxLineLength);
        System.out.println("Длина самой короткой строки: " + (minLineLength == Integer.MAX_VALUE ? 0 : minLineLength));
    }
}
