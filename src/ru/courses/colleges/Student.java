package ru.courses.colleges;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public final class Student {
    private List<Integer> grades = new ArrayList<>();
    private String name;
    private Predicate<Integer>gradeValidator;

    public Student(String name, Predicate<Integer> gradeValidator) {
        this.name = name;
        this.gradeValidator = gradeValidator;
    }

    public void addGrade(int grade) {
        if (gradeValidator.test(grade)) {
            this.grades.add(grade);
        } else {
            System.out.println("Оценка " + grade + " недопустима для студента " + name);
        }
    }
    @Override
    public String toString() {
        return "Имя: " + name + " Оценки: " + grades;
    }
}
