package ru.courses.agent;

public enum HttpMethod {
    GET, POST, PUT, DELETE;
    public static HttpMethod fromString(String method) {
        return HttpMethod.valueOf(method.toUpperCase());
    }
}
