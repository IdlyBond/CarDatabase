package gui;

import gui.input.EnterFields;
import mechanics.exceptions.CarNotFoundException;
import mechanics.facade.CarDatabase;
import mechanics.facade.Database;
import mechanics.processor.cars.Car;

import static mechanics.facade.DataTypes.*;

public class ChangerGUI {

    private Database database;
    private EnterFields enter;
    private FindGUI findGUI;

    public ChangerGUI(EnterFields enter, FindGUI findGUI) {
        this.database = CarDatabase.getInstance();
        this.enter = enter;
        this.findGUI = findGUI;
    }

    public void changeVin(){
        try {
            Car car = findGUI.findByVin().iterator().next();
            System.out.println(Lines.ENTER_NEW_VALUE);
            database.update(enter.vin(), car, VIN);
            System.out.println(Lines.CHANGES_SUCCESS);
        } catch (CarNotFoundException e) {
            System.out.println("Машин с VIN " + e.getField() + " не было найдено");
        }
    }

    public void changeReg(){
        try {
            Car car = findGUI.findByVin().iterator().next();
            System.out.println(Lines.ENTER_NEW_VALUE);
            database.update(enter.reg(), car, REG);
            System.out.println(Lines.CHANGES_SUCCESS);
        } catch (CarNotFoundException e) {
            System.out.println("Машин с REG " + e.getField() + " не было найдено");
        }
    }

    public void changeModel(){
        try {
            Car car = findGUI.findByVin().iterator().next();
            System.out.println(Lines.ENTER_NEW_VALUE);
            database.update(enter.model(), car, MODEL);
            System.out.println(Lines.CHANGES_SUCCESS);
        } catch (CarNotFoundException e) {
            System.out.println("Машин с моделью " + e.getField() + " не было найдено");
        }
    }

    public void changePrice(){
        try {
            Car car = findGUI.findByVin().iterator().next();
            System.out.println(Lines.ENTER_NEW_VALUE);
            database.update(enter.price(), car, PRICE);
            System.out.println(Lines.CHANGES_SUCCESS);
        } catch (CarNotFoundException e) {
            System.out.println("В диапазне " + e.getField() + " машин нет");
        }
    }

    public void changePath(){
        try {
            Car car = findGUI.findByVin().iterator().next();
            System.out.println(Lines.ENTER_NEW_VALUE);
            database.update(enter.path(), car, PATH);
            System.out.println(Lines.CHANGES_SUCCESS);
        } catch (CarNotFoundException e) {
            System.out.println("В диапазне " + e.getField() + " машин нет");
        }
    }

    public void changeYear(){
        try {
            Car car = findGUI.findByVin().iterator().next();
            System.out.println(Lines.ENTER_NEW_VALUE);
            database.update(enter.year(), car, YEAR);
            System.out.println(Lines.CHANGES_SUCCESS);
        } catch (CarNotFoundException e) {
            System.out.println("В диапазне " + e.getField() + " машин нет");
        }
    }

    public void changeAll(){
        try {
            Car car = findGUI.findByVin().iterator().next();
            System.out.println(Lines.ENTER_NEW_VALUE);
            database.update(enter.vin(), car, VIN);
            System.out.println(Lines.ENTER_NEW_VALUE);
            database.update(enter.reg(), car, REG);
            System.out.println(Lines.ENTER_NEW_VALUE);
            database.update(enter.model(), car, MODEL);
            System.out.println(Lines.ENTER_NEW_VALUE);
            database.update(enter.price(), car, PRICE);
            System.out.println(Lines.ENTER_NEW_VALUE);
            database.update(enter.path(), car, PATH);
            System.out.println(Lines.ENTER_NEW_VALUE);
            database.update(enter.year(), car, YEAR);
            System.out.println(Lines.CHANGES_SUCCESS);
        } catch (CarNotFoundException e) {
            System.out.println(Lines.NO_CARS_FOUND);
        }
    }

}
