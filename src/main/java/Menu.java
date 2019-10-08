import mechanics.processor.Car;
import mechanics.processor.Changer;
import constants.Fields;
import constants.Lines;
import mechanics.processor.CarCollector;
import mechanics.exceptions.CarNotFoundException;
import utillities.Checker;
import utillities.Utils;

import java.util.Scanner;
import java.util.Set;

public class Menu {

    private CarCollector carCollector = new CarCollector();
    private Changer changer = new Changer();
    private Scanner scr = new Scanner(System.in);

    public void mainMenu(){
        while(true){
            System.out.println(Lines.CHOOSE_LINE);
            System.out.println(Lines.MAIN_OPTIONS_LINE);
            switch (Utils.printNumberFromTo(-1, 4, scr)){
                case 1:
                    searchMenu();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    change();
                    break;
                case 4:
                    delete();
                    break;
                case 0:
                    break;
                case -1:
                    return;
            }
        }
    }

    private void searchMenu(){
        while(true) {
            System.out.println(Lines.CHOOSE_LINE);
            System.out.println(Lines.SEARCH_OPTIONS_LINE);
            switch (Utils.printNumberFromTo(0, 7, scr)) {
                case 1:
                    find(Fields.VIN_CODE);
                    break;
                case 2:
                    find(Fields.REG_NUM);
                    break;
                case 3:
                    find(Fields.MODEL);
                    break;
                case 4:
                    find(Fields.PATH);
                    break;
                case 5:
                    find(Fields.YEAR);
                    break;
                case 6:
                    find(Fields.PRICE);
                    break;
                case 7:
                    printCars();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void printCars(){
        System.out.println(carCollector);
    }

    private void add(){
        carCollector.add((String)EnterFields.enter(Fields.VIN_CODE, scr),
                (String)EnterFields.enter(Fields.REG_NUM, scr),
                (String)EnterFields.enter(Fields.MODEL, scr),
                (int)EnterFields.enter(Fields.PATH, scr),
                (int)EnterFields.enter(Fields.YEAR, scr),
                (int)EnterFields.enter(Fields.PRICE, scr));
    }

    private void change() {
        while (true) {
            System.out.println(Lines.ZERO_TO_EXIT);
            String line = (String) EnterFields.enter(Fields.VIN_CODE, scr);
            if (Checker.isZero(line)) return;
            try {
                Car car = carCollector.search(line, Fields.VIN_CODE).iterator().next();
                System.out.println(Lines.WHAT_TO_CHANGE);
                System.out.println(Lines.CHANGE_OPTIONS);
                switch (Utils.printNumberFromTo(1, 7, scr)) {
                    case 1:
                        changer.change((String) EnterFields.enter(Fields.VIN_CODE, scr), Fields.VIN_CODE, car);
                        break;
                    case 2:
                        changer.change((String) EnterFields.enter(Fields.REG_NUM, scr), Fields.REG_NUM, car);
                        break;
                    case 3:
                        changer.change((String) EnterFields.enter(Fields.MODEL, scr), Fields.MODEL, car);
                        break;
                    case 4:
                        changer.change((int) EnterFields.enter(Fields.PATH, scr), Fields.PATH, car);
                        break;
                    case 5:
                        changer.change((int) EnterFields.enter(Fields.YEAR, scr), Fields.YEAR, car);
                        break;
                    case 6:
                        changer.change((int) EnterFields.enter(Fields.PRICE, scr), Fields.PRICE, car);
                        break;
                    case 7:
                        changer.change((String) EnterFields.enter(Fields.VIN_CODE, scr), Fields.VIN_CODE, car);
                        changer.change((String) EnterFields.enter(Fields.REG_NUM, scr), Fields.REG_NUM, car);
                        changer.change((String) EnterFields.enter(Fields.MODEL, scr), Fields.MODEL, car);
                        changer.change((String) EnterFields.enter(Fields.PATH, scr), Fields.PATH, car);
                        changer.change((String) EnterFields.enter(Fields.YEAR, scr), Fields.YEAR, car);
                        changer.change((String) EnterFields.enter(Fields.PRICE, scr), Fields.PRICE, car);
                        break;
                }
            } catch (CarNotFoundException e) {
                System.out.println(e.getText());
            }
        }
    }

    private void delete() {
        while(true){
            System.out.println(Lines.ZERO_TO_EXIT);
            String line = (String) EnterFields.enter(Fields.VIN_CODE, scr);
            if(Checker.isZero(line)) return;
            carCollector.removeByVin(line);
        }
    }

    private void find(Fields type){
        while(true) {
            System.out.println(Lines.ZERO_TO_EXIT);
            if(type == Fields.VIN_CODE || type == Fields.REG_NUM || type == Fields.MODEL){
                String line = (String)EnterFields.enter(type, scr);
                if (Checker.isZero(line)) return;
                try {
                    Set<Car> cars = carCollector.search(line, type);
                    cars.forEach(System.out::println);
                } catch (CarNotFoundException e) {
                    System.out.println(e.getText());
                }
            }
            else if(type == Fields.PRICE || type == Fields.PATH || type == Fields.YEAR){
                int from = Integer.parseInt(EnterFields.enter(type, scr).toString());
                if (from == 0) return;
                int to = Integer.parseInt(EnterFields.enter(type, scr).toString());
                System.out.println(">=" + from + "&" + "<=" + to);
                try {
                Set<Car> cars = carCollector.search(from, to, type);
                cars.forEach(System.out::println);
                } catch (CarNotFoundException e) {
                    System.out.println(e.getText());
                }
            }
        }
    }

}


