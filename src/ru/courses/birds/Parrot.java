package ru.courses.birds;

public class Parrot extends Bird {
    private String text;
    public Parrot(String text) {
        this.text = text;
    }
    @Override
    public void sing() {
        int n = random.nextInt(text.length())+1;
        System.out.println(text.substring(0, n));
    }
}
