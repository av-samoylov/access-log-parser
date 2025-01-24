package ru.courses.geometry;

public class Circle extends Shape {
    private double radius;
    public Point center;

    public Circle(double radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
