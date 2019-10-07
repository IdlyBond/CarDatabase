package utillities;

import java.util.Objects;
import java.util.Scanner;

public abstract class Utils {

    public static int printNumberFromTo(int from, int to, Scanner scr){
        while(true) {
            Integer number = null;
            if (scr.hasNextInt()) number = scr.nextInt();
            if (Objects.nonNull(number) && number >= from && number <= to) return number;
            System.out.println("* Попробуйте еще раз.");
        }
    }

    public static int printNumberFromTo(int from, Scanner scr){
        while(true) {
            Integer number = null;
            if (scr.hasNextInt()) number = scr.nextInt();
            if (Objects.nonNull(number) && number >= from) return number;
            System.out.println("* Попробуйте еще раз.");
        }
    }

    public static int printNumber(Scanner scr){
        while(true) {
            if (scr.hasNextInt()) return scr.nextInt();
            System.out.println("* Попробуйте еще раз.");
            scr.next();
        }
    }

    public static int printNumberFromTo(int from, int to, int and, Scanner scr){
        while(true) {
            Integer number = null;
            if (scr.hasNextInt()) number = scr.nextInt();
            if (Objects.nonNull(number) && (number >= from && number <= to || number == and)) return number;
            System.out.println("* Попробуйте еще раз.");
        }
    }

    public static String printLine(Scanner scr){
        return new Scanner(System.in).nextLine();
    }

    public static String printLine(String regex, Scanner scr){
        while(true) {
            if (scr.nextLine().trim().matches(regex)) return scr.nextLine();
        }
    }

}
