package ru.courses.birds;

public class Cuckoo extends Bird {
    @Override
    public void sing() {
        int items = random.nextInt(10)+1;

        for (int i = 0; i < items; i++) {
            System.out.print("ку - ку ");
        }
        System.out.println();
    }
}
