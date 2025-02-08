package ru.courses.main;


import ru.courses.collections.task_1.LogEntry;
import ru.courses.collections.task_1.Statistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics();

        try (BufferedReader br = new BufferedReader(new FileReader("access.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    LogEntry entry = new LogEntry(line);
                    stats.addEntry(entry);
                } catch (Exception e) {
                    System.err.println("Ошибка разбора строки: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + e.getMessage(), e);
        }

        System.out.println("Средний трафик за час: " + stats.getTrafficRate());

        System.out.println("Статистика браузеров:");
        for (Map.Entry<String, Double> entry : stats.getOsStatistics().entrySet()) {
            System.out.println(entry.getKey() + ": " + String.format("%.3f", entry.getValue()) + "%");
        }
    }
}
