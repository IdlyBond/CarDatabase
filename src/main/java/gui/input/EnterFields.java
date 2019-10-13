package gui.input;

import carUtils.CarUtils;
import gui.Lines;

public class EnterFields {
    private Printer print;

    public EnterFields(Printer print) {
        this.print = print;
    }

    public String vin() {
        while (true) {
            System.out.println(Lines.ENTER_VIN_CODE);
            String line = print.line();
            if (CarUtils.checkVinCode(line) || CarUtils.lineIsZero(line)) return line;
            System.out.println(Lines.NON_CORRECT);
        }
    }

    public String reg() {
        while (true) {
            System.out.println(Lines.ENTER_REG_NUMBER);
            String line = print.line();
            if (CarUtils.checkRegNumber(line) || CarUtils.lineIsZero(line)) return line;
            System.out.println(Lines.NON_CORRECT);
        }
    }

    public String model() {
        while (true) {
            System.out.println(Lines.ENTER_MODEL);
            String line = print.line();
            if (CarUtils.checkModel(line) || CarUtils.lineIsZero(line)) return line;
            System.out.println(Lines.NON_CORRECT);
        }
    }

    public Integer path() {
        while (true) {
            System.out.println(Lines.ENTER_PATH);
            int number = print.number();
            if (CarUtils.checkPath(number)) return number;
            System.out.println(Lines.NON_CORRECT);
        }
    }

    public Integer year() {
        while (true) {
            System.out.println(Lines.ENTER_YEAR);
            int number = print.number();
            if (CarUtils.checkYear(number) || number == 0) return number;
            System.out.println(Lines.NON_CORRECT);
        }
    }

    public Integer price() {
        while (true) {
            System.out.println(Lines.ENTER_PRICE);
            int number = print.number();
            if (CarUtils.checkPrice(number) || number == 0) return number;
            System.out.println(Lines.NON_CORRECT);
        }
    }

}
