package ru.courses.arifmetika;

import ru.courses.geometry.Measurable;

public class StringWrapper implements Measurable {
    private String str;

    public StringWrapper(String str) {
        this.str = str;
    }

    @Override
    public double getLength() {
        return str.length();
    }
}
