package ru.courses.colleges;

import java.util.ArrayList;
import java.util.List;

public class StudentGrade {
    private final String name;
    private final List<Integer> grades;

    public StudentGrade(String name, int... grades) {
        if (name == null || name.strip().isEmpty()) {
            throw new IllegalArgumentException("Имя студента не может быть пустым.");
        }
        this.name = name;
        this.grades = new ArrayList<>();
        for (int grade : grades) {
            addGrade(grade);
        }
    }


    public void addGrade(int grade) {
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException("Оценка должна быть  в диапазоне от 2 до 5.");
        }
        grades.add(grade);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    @Override
    public String toString() {
        return "Имя: " + name + " Оценки: " + grades;
    }

    public static void main(String[] args) {
        StudentGrade student = new StudentGrade("Иван ", 4, 5, 3);

        System.out.println(student);

        student.addGrade(2);
        student.addGrade(3);
        student.addGrade(4);
        student.addGrade(5);
        System.out.println(student);
        System.out.println("Все оценки: " + student.getGrades());
    }
}

