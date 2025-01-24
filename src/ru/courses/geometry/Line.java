package ru.courses.geometry;

public class Line implements Measurable {
    private final Point start;
    private final Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public double getLength() {
        return start.distanceTo(end);
    }

    @Override
    public String toString() {
        return "Линия от {" + start.toString() + "} до {" + end.toString() + "}";
    }

}