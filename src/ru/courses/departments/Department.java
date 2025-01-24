package ru.courses.departments;

public class Department {
    private final String name;
    private final Employee boss;

    public Department(String name, Employee boss) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название отдела не может быть пустым.");
        }
        if (boss == null) {
            throw new IllegalArgumentException("Начальник отдела не может быть null.");
        }
        this.name = name;
        this.boss = boss;
        boss.setDep(this);
    }

    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }
}
