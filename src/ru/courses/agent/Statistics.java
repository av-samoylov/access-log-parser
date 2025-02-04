package ru.courses.agent;

import java.time.LocalDateTime;

public class Statistics {
    private  int totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;

    public Statistics(){
        this.totalTraffic = 0;
        this.minTime = LocalDateTime.MAX;
        this.maxTime = LocalDateTime.MIN;
    }

    public void addLogEntry(LogEntry entry){
        totalTraffic += entry.getResponseSize();
        if (entry.getReguestTime().isBefore(minTime)) minTime = entry.getReguestTime();
        if (entry.getReguestTime().isAfter(maxTime)) maxTime = entry.getReguestTime();
    }

    public double getTrafficRate() {
        long hoursDiff = java.time.Duration.between(minTime, maxTime).toHours();
        if (hoursDiff == 0) return totalTraffic;
        return (double) totalTraffic / hoursDiff;
    }
}
