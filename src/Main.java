import java.util.Scanner;

import static java.awt.SystemColor.text;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите первое число: ");
        int firstNumber = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число: ");
        int secondNumber = new Scanner(System.in).nextInt();

        int product = firstNumber * secondNumber;
        System.out.println("Произведение: " + product);

        double quotient = (double) firstNumber / secondNumber;
        System.out.println("Частное: " + quotient);

        int sum = firstNumber + secondNumber;
        System.out.println("Сумма: " + sum);

        int difference = firstNumber - secondNumber;
        System.out.println("Разность: " + difference);
    }
}
