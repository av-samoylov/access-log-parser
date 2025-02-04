package ru.courses.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AccessLogParser {
    public static void main(String[] args) {
        String path = "C:\\Users\\Admin\\Downloads\\access.log";
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            System.out.println("Указанный путь не существует или не является файлом.");
            return;
        }
        int totalLines = 0;
        int googlebotCount = 0;
        int yandexbotCount = 0;

        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                totalLines++;
                int length = line.length();
                if (length > 1024) {
                    throw new LineTooLongException("Строка превышает 1024 символа: " + length);
                }
                String[] parts = line.split("\" ");
                if (parts.length < 2) {
                    continue;
                }

                String userAgent = parts[parts.length - 1];
                if (userAgent.startsWith("\"")) {
                    userAgent = userAgent.substring(1, userAgent.length() - 1);
                }

                int start = userAgent.indexOf("(");
                int end = userAgent.indexOf(")");
                if (start != -1 && end != -1 && start < end) {
                    String firstBrackets = userAgent.substring(start + 1, end);
                    String[] userAgentParts = firstBrackets.split(";");
                    if (userAgentParts.length >= 2) {
                        String fragment = userAgentParts[1].trim();
                        String botName = fragment.split("/")[0];

                        if ("Googlebot".equals(botName)) {
                            googlebotCount++;
                        } else if ("YandexBot".equals(botName)) {
                            yandexbotCount++;
                        }
                    }
                }
            }
        } catch (LineTooLongException e) {
            System.err.println(e.getMessage());
            return;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Общее количество строк: " + totalLines);
        System.out.println("Доля запросов от Googlebot: " + (totalLines > 0 ? (double) googlebotCount / totalLines * 100 : 0) + " %");
        System.out.println("Доля запросов от YandexBot: " + (totalLines > 0 ? (double) yandexbotCount / totalLines * 100 : 0) + " %");
    }
}
