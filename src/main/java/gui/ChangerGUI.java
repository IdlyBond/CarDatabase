package gui;

import gui.input.EnterFields;
import mechanics.exceptions.CarNotFoundException;
import mechanics.processor.Car;
import mechanics.processor.CarDatabase;

class ChangerGUI {

    private CarDatabase carDatabase;
    private EnterFields enter;
    private FindGUI findGUI;

    ChangerGUI(CarDatabase carDatabase, EnterFields enter, FindGUI findGUI) {
        this.carDatabase = carDatabase;
        this.enter = enter;
        this.findGUI = findGUI;
    }

    void changeVin(){
        try {
            Car car = findGUI.findByVin().iterator().next();
            System.out.println(Lines.ENTER_NEW_VALUE);
            carDatabase.changeVin(enter.vin(), car);
            System.out.println(Lines.CHANGES_SUCCESS);
        } catch (CarNotFoundException e) {
            System.out.println("Машин с VIN " + e.getField() + " не было найдено");
        }
    }

    void changeReg(){
        try {
            Car car = findGUI.findByVin().iterator().next();
            System.out.println(Lines.ENTER_NEW_VALUE);
            carDatabase.changeReg(enter.reg(), car);
            System.out.println(Lines.CHANGES_SUCCESS);
        } catch (CarNotFoundException e) {
            System.out.println("Машин с REG " + e.getField() + " не было найдено");
        }
    }

    void changeModel(){
        try {
            Car car = findGUI.findByVin().iterator().next();
            System.out.println(Lines.ENTER_NEW_VALUE);
            carDatabase.changeModel(enter.model(), car);
            System.out.println(Lines.CHANGES_SUCCESS);
        } catch (CarNotFoundException e) {
            System.out.println("Машин с моделью " + e.getField() + " не было найдено");
        }
    }

    void changePrice(){
        try {
            Car car = findGUI.findByVin().iterator().next();
            System.out.println(Lines.ENTER_NEW_VALUE);
            carDatabase.changePrice(enter.price(), car);
            System.out.println(Lines.CHANGES_SUCCESS);
        } catch (CarNotFoundException e) {
            System.out.println("В диапазне " + e.getField() + " машин нет");
        }
    }

    void changePath(){
        try {
            Car car = findGUI.findByVin().iterator().next();
            System.out.println(Lines.ENTER_NEW_VALUE);
            carDatabase.changePath(enter.path(), car);
            System.out.println(Lines.CHANGES_SUCCESS);
        } catch (CarNotFoundException e) {
            System.out.println("В диапазне " + e.getField() + " машин нет");
        }
    }

    void changeYear(){
        try {
            Car car = findGUI.findByVin().iterator().next();
            System.out.println(Lines.ENTER_NEW_VALUE);
            carDatabase.changeYear(enter.year(), car);
            System.out.println(Lines.CHANGES_SUCCESS);
        } catch (CarNotFoundException e) {
            System.out.println("В диапазне " + e.getField() + " машин нет");
        }
    }

    void changeAll(){
        try {
            Car car = findGUI.findByVin().iterator().next();
            System.out.println(Lines.ENTER_NEW_VALUE);
            carDatabase.changeVin(enter.vin(), car);
            System.out.println(Lines.ENTER_NEW_VALUE);
            carDatabase.changeReg(enter.reg(), car);
            System.out.println(Lines.ENTER_NEW_VALUE);
            carDatabase.changeModel(enter.model(), car);
            System.out.println(Lines.ENTER_NEW_VALUE);
            carDatabase.changePrice(enter.price(), car);
            System.out.println(Lines.ENTER_NEW_VALUE);
            carDatabase.changePath(enter.path(), car);
            System.out.println(Lines.ENTER_NEW_VALUE);
            carDatabase.changeYear(enter.year(), car);
            System.out.println(Lines.CHANGES_SUCCESS);
        } catch (CarNotFoundException e) {
            System.out.println(Lines.NO_CARS_FOUND);
        }
    }

}
