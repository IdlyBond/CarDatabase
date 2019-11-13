package gui;

import gui.input.EnterFields;
import gui.input.Printer;
import mechanics.exceptions.CarNotFoundException;
import mechanics.facade.CarDatabase;
import mechanics.facade.Database;
import mechanics.processor.CRUD;
import mechanics.processor.CarCRUD;


public class Menu {

    private Database carCRUD;
    private Printer print;
    private EnterFields enter;
    private FindGUI findGUI;
    private DeleteGUI deleteGUI;
    private ChangerGUI changerGUI;

    public Menu() {
        this.carCRUD = CarDatabase.getInstance();
        this.print = new Printer();
        this.enter = new EnterFields(print);
        this.findGUI = new FindGUI(enter);
        this.deleteGUI = new DeleteGUI(enter);
        this.changerGUI = new ChangerGUI(enter, findGUI);
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
                    changeMenu();
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

    private void changeMenu() {
        while (true) {
            System.out.println(Lines.CHOOSE_LINE);
            System.out.println(Lines.CHANGE_OPTIONS_LINE);
            switch (print.numberFromTo(0, 7)) {
                case 1:
                    changeVin();
                    break;
                case 2:
                    changeReg();
                    break;
                case 3:
                    changeModel();
                    break;
                case 4:
                    changePath();
                    break;
                case 5:
                    changeYear();
                    break;
                case 6:
                    changePrice();
                    break;
                case 7:
                    changeAll();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void add() {
        carCRUD.insert(enter.vin(), enter.reg(), enter.model(), enter.path(), enter.year(), enter.price());
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

    private void changeVin(){
        changerGUI.changeVin();
    }

    private void changeReg(){
        changerGUI.changeReg();
    }

    private void changeModel(){
        changerGUI.changeModel();
    }

    private void changePath(){
        changerGUI.changePath();
    }

    private void changeYear(){
        changerGUI.changeYear();
    }

    private void changePrice(){
        changerGUI.changePrice();
    }

    private void changeAll(){
        changerGUI.changeAll();
    }

    private void printByVin() {
        try {
            findGUI.findByVin().forEach(System.out::println);
        } catch (CarNotFoundException e) {
            System.out.println("Машин с VIN " + e.getField() + " не было найдено");
        }
    }

    private void printByReg() {
        try {
            findGUI.findByReg().forEach(System.out::println);
        } catch (CarNotFoundException e) {
            System.out.println("Машин с REG " + e.getField() + " не было найдено");
        }
    }

    private void printByModel() {
        try {
            findGUI.findByModel().forEach(System.out::println);
        } catch (CarNotFoundException e) {
            System.out.println("Машин с моделью " + e.getField() + " не было найдено");
        }
    }

    private void printByPrice() {
        try {
            findGUI.findByPrice().forEach(System.out::println);
        } catch (CarNotFoundException e) {
            System.out.println("В диапазне " + e.getField() + " машин нет");
        }
    }

    private void printByPath() {
        try {
            findGUI.findByPath().forEach(System.out::println);
        } catch (CarNotFoundException e) {
            System.out.println("В диапазне " + e.getField() + " машин нет");
        }
    }

    private void printByYear() {
        try {
            findGUI.findByYear().forEach(System.out::println);
        } catch (CarNotFoundException e) {
            System.out.println("В диапазне " + e.getField() + " машин нет");
        }
    }

    private void printCars() {
        try {
            System.out.println(carCRUD.select());
        } catch (CarNotFoundException e) {
            System.out.println(Lines.NO_CARS_FOUND);
        }
    }


}


