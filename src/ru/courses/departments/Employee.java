package ru.courses.departments;

public class Employee {
    private final String name;
    private Department dep;

    public Employee(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя сотрудника не может быть пустым.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        if (this.dep != null && this.dep.getBoss() == this) {
            throw new IllegalArgumentException("Начальник отдела не может быть переведен в другой отдел.");
        }
        this.dep = dep;
    }


    @Override
    public String toString() {
        if (dep != null) {
            if (this.equals(dep.getBoss())) {
                return name + " начальник отдела " + dep.getName();
            } else {
                return name + " работает в отделе " + dep.getName() +
                        ", начальник которого " + dep.getBoss().getName();
            }
        }
        return name + " не привязан к отделу.";
    }
}

