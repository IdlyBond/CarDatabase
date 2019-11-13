package gui;

import gui.input.EnterFields;
import mechanics.exceptions.CarNotFoundException;
import mechanics.facade.CarDatabase;
import mechanics.facade.Database;
import utils.CarUtils;

import static mechanics.facade.DataTypes.*;

public class DeleteGUI {

    private Database database;
    private EnterFields enter;

    public DeleteGUI(EnterFields enter) {
        this.database = CarDatabase.getInstance();
        this.enter = enter;
    }

    public void deleteByVin() {
        try {
            database.delete(enter.vin(), VIN);
        } catch (CarNotFoundException e) {
            System.out.println(Lines.NO_CARS_FOUND);
        }
    }

    public void deleteByReg() {
        try {
        database.delete(enter.reg(), REG);
        } catch (CarNotFoundException e) {
            System.out.println(Lines.NO_CARS_FOUND);
        }
    }

    public void deleteByModel() {
        try {
        database.delete(enter.model(), MODEL);
        } catch (CarNotFoundException e) {
            System.out.println(Lines.NO_CARS_FOUND);
        }
    }

    public void deleteByPrice() {
        int from;
        int to;
        while (true) {
            from = enter.price();
            to = enter.price();
            if (!CarUtils.isLess(from, to)) break;
            System.out.println(Lines.NON_CORRECT);
        }
        try {
        database.delete(from, to, PRICE);
        } catch (CarNotFoundException e) {
            System.out.println(Lines.NO_CARS_FOUND);
        }
    }

    public void deleteByPath() {
        int from;
        int to;
        while (true) {
            from = enter.path();
            to = enter.path();
            if (!CarUtils.isLess(from, to)) break;
            System.out.println(Lines.NON_CORRECT);
        }
        try {
        database.delete(from, to, PRICE);
        } catch (CarNotFoundException e) {
            System.out.println(Lines.NO_CARS_FOUND);
        }
    }

    public void deleteByYear() {
        int from;
        int to;
        while (true) {
            from = enter.year();
            to = enter.year();
            if (!CarUtils.isLess(from, to)) break;
            System.out.println(Lines.NON_CORRECT);
        }
        try {
        database.delete(from, to, YEAR);
        } catch (CarNotFoundException e) {
            System.out.println(Lines.NO_CARS_FOUND);
        }
    }

    public void deleteAll() {
        try {
        database.delete();
        } catch (CarNotFoundException e) {
            System.out.println(Lines.NO_CARS_FOUND);
        }
    }

}
