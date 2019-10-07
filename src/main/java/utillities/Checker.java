package utillities;

import java.time.LocalDate;
import java.util.Objects;

public class Checker {

    public static boolean checkVinCode(String line){
        return Objects.nonNull(line);
    }

    public static boolean checkYear(int year){
        return (year >= 1900 && year <= LocalDate.now().getYear());
    }

    public static boolean checkRegNumber(String line){
        if(Objects.isNull(line)) return false;
        return line.trim().length() == 8 && line.trim().matches("^[A-C][A-Z]\\d{4}[A-C][A-Z]$");
    }

    public static boolean checkModel(String line){
        if(Objects.isNull(line)) return false;
        return line.trim().length() != 0;
    }

    public static boolean checkPrice(int num){
        return num >= 0;
    }

    public static boolean checkPath(int num){
        return num >= 0;
    }

    public static boolean isZero(String line){
        if(Objects.isNull(line)) return false;
        return line.trim().length() == 1 && line.trim().equals("0");
    }

    public static boolean isZeroOrMore(int number){
        return number >= 0;
    }

}
