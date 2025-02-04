package ru.courses.agent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogEntry {
    private final String ipAddress;
    private final LocalDateTime requestTime;
    private final HttpMethod httpMethod;
    private final String requestPath;
    private final int responseCode;
    private final int responseSize;
    private final String referer;
    private final UserAgent userAgent;

    public LogEntry(String logLine) {
        String[] parts = logLine.split("\\|");
        String[] requestParts = parts[1].split(" ");

        this.ipAddress = parts[0].split(" ")[0];
        this.requestTime = parseDate(parts[0]);
        this.httpMethod = HttpMethod.fromString(requestParts[0]);
        this.requestPath = requestParts[1];
        this.responseCode = Integer.parseInt(requestParts[2]);
        this.responseSize = Integer.parseInt(parts[2].trim());
        this.referer = parts.length > 3 ? parts[3].trim() : "";
        this.userAgent = new UserAgent(parts[5].trim());
    }
    private LocalDateTime parseDate(String part) {
        String dateTimePart = part.substring(part.indexOf("[") + 1, part.indexOf("]"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z");
        return LocalDateTime.parse(dateTimePart, formatter);
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDateTime getReguestTime() {
        return requestTime;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getReguestPath() {
        return requestPath;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public int getResponseSize() {
        return responseSize;
    }

    public String getReferer() {
        return referer;
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }
}

