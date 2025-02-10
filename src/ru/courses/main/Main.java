package ru.courses.main;

import ru.courses.streamAPI.task_2.LogEntry;
import ru.courses.streamAPI.task_2.Statistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Statistics statistics = getStatistics();

        System.out.println("Пик трафика веб-сайта в секунду: " + statistics.getPeakVisitsPerSecond());
        System.out.println("Максимальное количество посещений сайта одним пользователем: " + statistics.getMaxVisitsByOneUser());
        System.out.println("Список сайтов с ссылками на текущий сайт: " + statistics.getReferers());
    }

    private static Statistics getStatistics() {
        Statistics statistics = new Statistics();
        try (BufferedReader br = new BufferedReader(new FileReader("access.txt"))) {
            String line;
            LogEntry entry;
            while ((line = br.readLine()) != null) {
                try {
                    entry = new LogEntry(line);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                statistics.addEntry(entry);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return statistics;
    }
}