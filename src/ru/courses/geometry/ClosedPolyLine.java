package ru.courses.geometry;

public class ClosedPolyLine extends PolyLine {
    public ClosedPolyLine(Point... points) {
        super(points);
    }

    @Override
    public double getLength() {
        double sum = super.getLength();
        if (getPoints().size() > 1) {
            Point first = getPoints().get(0);
            Point last = getPoints().get(getPoints().size() - 1);
            sum += first.distanceTo(last);
        }
        return sum;
    }

    @Override
    public String toString() {
        return "ClosedPolyLine{" +
                "points=" + getPoints() +
                '}';
    }
}