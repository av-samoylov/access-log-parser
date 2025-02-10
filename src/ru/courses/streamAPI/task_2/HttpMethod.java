package ru.courses.streamAPI.task_2;

public enum HttpMethod {
    GET, POST, PUT, DELETE, HEAD, OPTIONS, PATCH, TRACE, CONNECT;

    public static HttpMethod fromString(String method) {
        try {
            return HttpMethod.valueOf(method.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}

