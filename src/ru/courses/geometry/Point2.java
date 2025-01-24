package ru.courses.geometry;

import java.util.Arrays;

public class Point2 {
    private int[] coordinates;
    private String color;
    private String appearanceTime;

    public Point2(Builder builder) {
        this.coordinates = builder.coordinates;
        this.color = builder.color;
        this.appearanceTime = builder.appearanceTime;
    }

    public String getColor() {
        return color;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public String getAppearanceTime() {
        return appearanceTime;
    }

    @Override
    public String toString() {
        return "Point{" +
                "coordinates=" + Arrays.toString(coordinates) +
                ", color='" + color + '\'' +
                ", appearanceTime='" + appearanceTime + '\'' +
                '}';
    }

    public static class Builder {
        private int[] coordinates;
        private String color;
        private String appearanceTime;

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setAppearanceTime(String appearanceTime) {
            this.appearanceTime = appearanceTime;
            return this;
        }

        public Builder setCoordinates(int... coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        public Point2 build() {
            return new Point2(this);
        }
    }
}
