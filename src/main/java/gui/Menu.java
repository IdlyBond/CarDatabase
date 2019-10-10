package gui;

import gui.input.EnterFields;
import gui.input.Printer;
import mechanics.exceptions.CarNotFoundException;
import mechanics.processor.Car;
import mechanics.processor.CarDatabase;
import utillities.Checker;


public class Menu {

    private CarDatabase carDatabase;
    private Printer print;
    private EnterFields enter;
    private FindGUI findGUI;
    private DeleteGUI deleteGUI;

    public Menu(CarDatabase carDatabase) {
        this.carDatabase = carDatabase;
        this.print = new Printer();
        this.enter = new EnterFields(print);
        this.findGUI = new FindGUI(carDatabase, enter);
        this.deleteGUI = new DeleteGUI(carDatabase, enter);
    }

    public Menu() {
        this.carDatabase = new CarDatabase();
        this.print = new Printer();
        this.enter = new EnterFields(print);
        this.findGUI = new FindGUI(carDatabase, enter);
        this.deleteGUI = new DeleteGUI(carDatabase, enter);
    }

    public void mainMenu() {
        while (true) {
            System.out.println(Lines.CHOOSE_LINE);
            System.out.println(Lines.MAIN_OPTIONS_LINE);
            switch (print.numberFromTo(-1, 4)) {
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
                    deleteMenu();
                    break;
                case 0:
                    break;
                case -1:
                    return;
            }
        }
    }

    private void searchMenu() {
        while (true) {
            System.out.println(Lines.CHOOSE_LINE);
            System.out.println(Lines.SEARCH_OPTIONS_LINE);
            switch (print.numberFromTo(0, 7)) {
                case 1:
                    printByVin();
                    break;
                case 2:
                    printByReg();
                    break;
                case 3:
                    printByModel();
                    break;
                case 4:
                    printByPath();
                    break;
                case 5:
                    printByYear();
                    break;
                case 6:
                    printByPrice();
                    break;
                case 7:
                    printCars();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void deleteMenu() {
        while (true) {
            System.out.println(Lines.CHOOSE_LINE);
            System.out.println(Lines.DELETE_OPTIONS_LINE);
            switch (print.numberFromTo(0, 7)) {
                case 1:
                    deleteByVin();
                    break;
                case 2:
                    deleteByReg();
                    break;
                case 3:
                    deleteByModel();
                    break;
                case 4:
                    deleteByPath();
                    break;
                case 5:
                    deleteByYear();
                    break;
                case 6:
                    deleteByPrice();
                    break;
                case 7:
                    deleteAll();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void add() {
        carDatabase.add(enter.vin(), enter.reg(), enter.model(), enter.path(), enter.year(), enter.price());
    }

    private void printCars() {
        if (carDatabase.isEmpty()) {
            System.out.println(Lines.NO_CARS_FOUND);
            return;
        }
        System.out.println(carDatabase);
    }


    private void change() {
        while (true) {
            System.out.println(Lines.ZERO_TO_EXIT);
            String vin = enter.vin();
            if (Checker.isZero(vin)) return;
            Car car;
            try {
                car = carDatabase.searchByVin(vin).iterator().next();
            } catch (CarNotFoundException e) {
                System.out.println(Lines.NO_CARS_FOUND);
                continue;
            }
            System.out.println(Lines.WHAT_TO_CHANGE);
            System.out.println(Lines.CHANGE_OPTIONS);
            switch (print.numberFromTo(1, 7)) {
                case 1:
                    car.setVinCode(enter.vin());
                    break;
                case 2:
                    car.setRegNumber(enter.reg());
                    break;
                case 3:
                    car.setModel(enter.model());
                    break;
                case 4:
                    car.setPath(enter.path());
                    break;
                case 5:
                    car.setYear(enter.year());
                    break;
                case 6:
                    car.setPrice(enter.price());
                    break;
                case 7:
                    car.setVinCode(enter.vin());
                    car.setRegNumber(enter.reg());
                    car.setModel(enter.model());
                    car.setPath(enter.path());
                    car.setYear(enter.year());
                    car.setPrice(enter.price());
                    break;
            }
        }
    }

    private void deleteByVin() {
        deleteGUI.deleteByVin();
    }

    private void deleteByReg() {
        deleteGUI.deleteByReg();
    }

    private void deleteByModel() {
        deleteGUI.deleteByModel();
    }

    private void deleteByPrice() {
        deleteGUI.deleteByPrice();
    }

    private void deleteByPath() {
        deleteGUI.deleteByPath();
    }

    private void deleteByYear() {
        deleteGUI.deleteByYear();
    }

    private void deleteAll() {
        System.out.println(Lines.ARE_YOU_SURE_TO_DELETE);
        switch (print.numberFromTo(0, 1)) {
            case 0:
                return;
            case 1:
                System.out.println(Lines.TYPE_DELETE_TO_DELETE);
                if (print.line().trim().equals(Lines.DELETE.toString())) {
                    deleteGUI.deleteAll();
                    System.out.println(Lines.CARS_DELETED);
                }
                break;
        }
    }

    private void printByVin() {
        try {
            findGUI.findByVin().forEach(System.out::println);
        } catch (CarNotFoundException e) {
            System.out.println(Lines.NO_CARS_FOUND);
        }
    }

    private void printByReg() {
        try {
            findGUI.findByReg().forEach(System.out::println);
        } catch (CarNotFoundException e) {
            System.out.println(Lines.NO_CARS_FOUND);
        }
    }

    private void printByModel() {
        try {
            findGUI.findByModel().forEach(System.out::println);
        } catch (CarNotFoundException e) {
            System.out.println(Lines.NO_CARS_FOUND);
        }
    }

    private void printByPrice() {
        try {
            findGUI.findByPrice().forEach(System.out::println);
        } catch (CarNotFoundException e) {
            System.out.println(Lines.NO_CARS_FOUND);
        }
    }

    private void printByPath() {
        try {
            findGUI.findByPath().forEach(System.out::println);
        } catch (CarNotFoundException e) {
            System.out.println(Lines.NO_CARS_FOUND);
        }
    }

    private void printByYear() {
        try {
            findGUI.findByYear().forEach(System.out::println);
        } catch (CarNotFoundException e) {
            System.out.println(Lines.NO_CARS_FOUND);
        }
    }


}


