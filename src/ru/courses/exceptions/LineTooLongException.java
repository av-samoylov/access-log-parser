package ru.courses.exceptions;

public class LineTooLongException extends RuntimeException{
    public LineTooLongException(String message) {
        super(message);
    }
}
