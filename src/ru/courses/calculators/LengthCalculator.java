package ru.courses.calculators;

import ru.courses.geometry.Measurable;

import java.util.List;

public class LengthCalculator {
    public static double calculateLength(List<Measurable> measurablest) {
        double sum = 0;
        for (Measurable measurable : measurablest) {
            sum += measurable.getLength();
        }
        return sum;
    }
}