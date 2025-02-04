package ru.courses.agent;

public class UserAgent {
    private final String operatingSystem;
    private final String browser;

    public UserAgent(String userAgentString) {
        this.operatingSystem = extractOperatingSystem(userAgentString);
        this.browser = extractBrowser(userAgentString);
    }
    private String extractOperatingSystem(String userAgent) {
        if (userAgent.contains("Windows")) {
            return "Windows";
        } else if (userAgent.contains("Mac")) {
            return "Mac";
        } else if (userAgent.contains("Linux")) {
            return "Linux";
        } else {
            return "Unknown";
        }
    }

    private String extractBrowser(String userAgent) {
        if (userAgent.contains("Edge")) {
            return "Edge";
        } else if (userAgent.contains("Firefox")) {
            return "Firefox";
        } else if (userAgent.contains("Chrome")) {
            return "Chrome";
        } else if (userAgent.contains("Opera")) {
            return "Opera";
        }
        return "Другой";
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getBrowser() {
        return browser;
    }
}
