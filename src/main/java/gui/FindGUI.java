package gui;

import gui.input.EnterFields;
import mechanics.exceptions.CarNotFoundException;
import mechanics.facade.CarDatabase;
import mechanics.facade.Database;
import mechanics.processor.cars.Car;
import utils.CarUtils;

import java.util.Collection;

import static mechanics.facade.DataTypes.*;

public class FindGUI {

    private Database database;
    private EnterFields enter;

    public FindGUI(EnterFields enter) {
        this.database = CarDatabase.getInstance();
        this.enter = enter;
    }

    public Collection<Car> findByVin() throws CarNotFoundException {
        return database.select(enter.vin(), VIN);
    }

    public Collection<Car> findByReg() throws CarNotFoundException {
        return database.select(enter.reg(), REG);
    }

    public Collection<Car> findByModel() throws CarNotFoundException {
        return database.select(enter.model(), MODEL);
    }

    public Collection<Car> findByPrice() throws CarNotFoundException {
        int from, to;
        while (true) {
            System.out.println(Lines.ENTER_FROM_TO);
            from = enter.price();
            to = enter.price();
            if (CarUtils.isLess(from, to)) {
                System.out.println(Lines.NON_CORRECT);
            } else break;
        }
        return database.select(from, to, PRICE);
    }

    public Collection<Car> findByPath() throws CarNotFoundException {
        int from, to;
        while (true) {
            System.out.println(Lines.ENTER_FROM_TO);
            from = enter.path();
            to = enter.path();
            if (from > to) {
                System.out.println(Lines.NON_CORRECT);
            } else break;
        }
        return database.select(from, to, PATH);
    }

    public Collection<Car> findByYear() throws CarNotFoundException {
        int from, to;
        while (true) {
            System.out.println(Lines.ENTER_FROM_TO);
            from = enter.year();
            to = enter.year();
            if (from > to) {
                System.out.println(Lines.NON_CORRECT);
            } else break;
        }
        return database.select(from, to, YEAR);
    }
}
