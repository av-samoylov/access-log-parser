package ru.courses.calculators;

public class SumCalculator {
    public static double sumAll(double... numbers) {
        double sum = 0.0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }
}
