import mechanics.exceptions.InvalidInputException;
import constants.Fields;
import constants.Lines;
import utillities.Checker;
import utillities.Utils;

import java.util.Objects;
import java.util.Scanner;

public class EnterFields {

    public static Object enter(Fields type, Scanner scr){
        if(Objects.isNull(type)) return null;
        switch (type){
            case VIN_CODE: return vin(scr);
            case REG_NUM: return reg(scr);
            case MODEL: return model(scr);
            case PRICE: return price(scr);
            case PATH: return path(scr);
            case YEAR: return year(scr);
            default: throw new InvalidInputException(type);
        }
    }

    private static String vin(Scanner scr){
        while(true) {
            System.out.println(Lines.ENTER_VIN_CODE);
            String line = Utils.printLine(scr);
            if(Checker.checkVinCode(line) || Checker.isZero(line)) return line;
            System.out.println(Lines.NON_CORRECT);
        }
    }

    private static String reg(Scanner scr){
        while(true) {
            System.out.println(Lines.ENTER_REG_NUMBER);
            String line = Utils.printLine(scr);
            if(Checker.checkRegNumber(line) || Checker.isZero(line)) return line;
            System.out.println(Lines.NON_CORRECT);
        }
    }

    private static String model(Scanner scr){
        while(true) {
            System.out.println(Lines.ENTER_MODEL);
            String line = Utils.printLine(scr);
            if(Checker.checkModel(line) || Checker.isZero(line)) return line;
            System.out.println(Lines.NON_CORRECT);
        }
    }

    private static Integer path(Scanner scr){
        while(true) {
            System.out.println(Lines.ENTER_PATH);
            int number = Utils.printNumber(scr);
            if(Checker.checkPath(number)) return number;
            System.out.println(Lines.NON_CORRECT);
        }
    }

    private static Integer year(Scanner scr){
        while(true) {
            System.out.println(Lines.ENTER_YEAR);
            int number = Utils.printNumber(scr);
            if(Checker.checkYear(number) || number == 0) return number;
            System.out.println(Lines.NON_CORRECT);
        }
    }

    private static Integer price(Scanner scr){
        while(true) {
            System.out.println(Lines.ENTER_PRICE);
            int number = Utils.printNumber(scr);
            if(Checker.checkPrice(number) || number == 0) return number;
            System.out.println(Lines.NON_CORRECT);
        }
    }

}
