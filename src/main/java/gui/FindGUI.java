package gui;

import gui.input.EnterFields;
import mechanics.exceptions.CarNotFoundException;
import mechanics.processor.Car;
import mechanics.processor.CarDatabase;
import utillities.Checker;

import java.util.Set;

class FindGUI {

    private CarDatabase carDatabase;
    private EnterFields enter;

    FindGUI(CarDatabase carDatabase, EnterFields enter) {
        this.carDatabase = carDatabase;
        this.enter = enter;
    }

    Set<Car> findByVin() throws CarNotFoundException {
        return carDatabase.searchByVin(enter.vin());
    }

    Set<Car> findByReg() throws CarNotFoundException {
        return carDatabase.searchByReg(enter.reg());
    }

    Set<Car> findByModel() throws CarNotFoundException {
        return carDatabase.searchByModel(enter.model());
    }

    Set<Car> findByPrice() throws CarNotFoundException {
        int from, to;
        while (true) {
            System.out.println(Lines.ENTER_FROM_TO);
            from = enter.price();
            to = enter.price();
            if (Checker.isLess(from, to)) {
                System.out.println(Lines.NON_CORRECT);
            } else break;
        }
        return carDatabase.searchByPrice(from, to);
    }

    Set<Car> findByPath() throws CarNotFoundException {
        int from, to;
        while (true) {
            System.out.println(Lines.ENTER_FROM_TO);
            from = enter.path();
            to = enter.path();
            if (from > to) {
                System.out.println(Lines.NON_CORRECT);
            } else break;
        }
        return carDatabase.searchByPath(from, to);
    }

    Set<Car> findByYear() throws CarNotFoundException {
        int from, to;
        while (true) {
            System.out.println(Lines.ENTER_FROM_TO);
            from = enter.year();
            to = enter.year();
            if (from > to) {
                System.out.println(Lines.NON_CORRECT);
            } else break;
        }
        return carDatabase.searchByYear(from, to);
    }
}
