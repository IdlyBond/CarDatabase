package gui.input;

import java.util.Scanner;

public class Printer {

    private Scanner scr = new Scanner(System.in);

    public int numberFromTo(int from, int to) {
        while (true) {
            int number = number();
            if (number >= from && number <= to) return number;
            System.out.println("* Введите значение из диапазона " + from + "-" + to);
        }
    }

    public int number() {
        while (true) {
            if (scr.hasNextInt()) return scr.nextInt();
            System.out.println("* Попробуйте еще раз.");
            scr.next();
        }
    }

    public String line() {
        return scr.next();
    }

}
