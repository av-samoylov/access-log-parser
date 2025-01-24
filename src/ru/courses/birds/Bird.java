package ru.courses.birds;

import java.util.Random;

public abstract class Bird {
    protected Random random = new Random();

    public abstract void sing();
}
