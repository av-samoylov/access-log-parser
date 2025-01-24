package ru.courses.arifmetika;

public class Fraction2 extends Number {
   private final int num, denum;

    public Fraction2(int num, int denum) {
        if (denum == 0) {
            throw new IllegalArgumentException("Делитель не может быть нулем.");
        }
        this.num = num;
        this.denum = denum;
    }

    @Override
    public int intValue() {
        return (int) (num / denum);
    }
    @Override
    public long longValue() {
        return (long) (num /  denum);
    }
    @Override
    public double doubleValue() {
        return (double) num / denum;
    }
    @Override
    public float floatValue() {
        return (float) num / denum;
    }

 @Override
    public String toString() {
        return num + "/" + denum;
    }
}
