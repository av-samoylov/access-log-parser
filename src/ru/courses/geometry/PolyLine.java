package ru.courses.geometry;

import java.util.ArrayList;

public class PolyLine implements Measurable {

    private final ArrayList<Point> points;

    public PolyLine(Point... points) {
        this.points = new ArrayList<>();
        for (Point point : points) {
            this.points.add(point);
        }
    }

    @Override
    public double getLength() {
        double sum = 0, len1, len2;
        for (int i = 0; i < points.size() - 1; i++) {
            len1 = points.get(i).getX() - points.get(i + 1).getX();
            len2 = points.get(i).getY() - points.get(i + 1).getY();
            sum += Math.sqrt(len1 * len1 + len2 * len2);
        }
        return sum;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    @Override
    public String toString() {
        return "PolyLine{" +
                "points=" + points +
                '}';
    }
}
