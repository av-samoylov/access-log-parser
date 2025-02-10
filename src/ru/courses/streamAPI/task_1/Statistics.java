package ru.courses.streamAPI.task_1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Statistics {
    private int totalTraffic = 0;
    private LocalDateTime minTime = null;
    private LocalDateTime maxTime = null;
    private final Map<String, Integer> osCounts = new HashMap<>();
    private final Map<String, Integer> browserCounts = new HashMap<>();
    private final Set<String> existingPages = new HashSet<>();
    private final Set<String> nonExistingPages = new HashSet<>();
    private int totalEntries = 0;
    private int totalRealVisits = 0;
    private final Set<String> uniqueRealUserIps = new HashSet<>();
    private int errorRequestsCount = 0;

    public void addEntry(LogEntry entry) {
        totalTraffic += entry.getResponseSize();
        totalEntries++;

        if (minTime == null || entry.getDateTime().isBefore(minTime)) {
            minTime = entry.getDateTime();
        }
        if (maxTime == null || entry.getDateTime().isAfter(maxTime)) {
            maxTime = entry.getDateTime();
        }

        String userAgentDesc = entry.getUserAgent().toString().toLowerCase();
        String os = entry.getUserAgent().getOs();
        osCounts.put(os, osCounts.getOrDefault(os, 0) + 1);
        String browser = entry.getUserAgent().getBrowser();
        browserCounts.put(browser, browserCounts.getOrDefault(browser, 0) + 1);

        if (entry.getResponseCode() == 200) {
            existingPages.add(entry.getRequestPath());
            if (!userAgentDesc.contains("bot")) {
                totalRealVisits++;
                uniqueRealUserIps.add(entry.getIpAddress());
            }
        } else if (entry.getResponseCode() >= 400 && entry.getResponseCode() < 600) {
            errorRequestsCount++;
        }
    }

    public double getTrafficRate() {
        if (minTime == null || maxTime == null || minTime.equals(maxTime)) {
            return 0;
        }
        long hours = Duration.between(minTime, maxTime).toHours();
        return (hours > 0) ? (double) totalTraffic / hours : totalTraffic;
    }

    public Set<String> getExistingPages() {
        return existingPages;
    }

    public Set<String> getNonExistingPages() {
        return nonExistingPages;
    }

    public Map<String, Double> getOsStatistics() {
        Map<String, Double> osStats = new HashMap<>();
        for (Map.Entry<String, Integer> entry : osCounts.entrySet()) {
            osStats.put(entry.getKey(), (double) entry.getValue() / totalEntries);
        }
        return osStats;
    }

    public Map<String, Double> getBrowserStatistics() {
        Map<String, Double> browserStats = new HashMap<>();
        for (Map.Entry<String, Integer> entry : browserCounts.entrySet()) {
            browserStats.put(entry.getKey(), (double) entry.getValue() / totalEntries);
        }
        return browserStats;
    }

    public double getAverageSiteVisitsPerHour() {
        if (minTime == null || maxTime == null || minTime.equals(maxTime)) {
            return 0;
        }
        long hours = Duration.between(minTime, maxTime).toHours();
        return (hours > 0) ? (double) totalRealVisits / hours : totalRealVisits;
    }

    public double getAverageErrorRequestsPerHour() {
        if (minTime == null || maxTime == null || minTime.equals(maxTime)) {
            return 0;
        }
        long hours = Duration.between(minTime, maxTime).toHours();
        return (hours > 0) ? (double) errorRequestsCount / hours : errorRequestsCount;
    }
    public double getAverageVisitsPerUser() {
        if (uniqueRealUserIps.isEmpty()) {
            return 0;
        }
        return (double) totalRealVisits / uniqueRealUserIps.size();
    }
}


