package gui;

import carUtils.CarUtils;
import gui.input.EnterFields;
import mechanics.processor.CarDatabase;

class DeleteGUI {

    private CarDatabase carDatabase;
    private EnterFields enter;

    DeleteGUI(CarDatabase carDatabase, EnterFields enter) {
        this.carDatabase = carDatabase;
        this.enter = enter;
    }

    void deleteByVin() {
        carDatabase.removeByVin(enter.vin());
    }

    void deleteByReg() {
        carDatabase.removeByReg(enter.reg());
    }

    void deleteByModel() {
        carDatabase.removeByModel(enter.model());
    }

    void deleteByPrice() {
        int from;
        int to;
        while (true) {
            from = enter.price();
            to = enter.price();
            if (!CarUtils.isLess(from, to)) break;
            System.out.println(Lines.NON_CORRECT);
        }
        carDatabase.removeByPrice(from, to);
    }

    void deleteByPath() {
        int from;
        int to;
        while (true) {
            from = enter.path();
            to = enter.path();
            if (!CarUtils.isLess(from, to)) break;
            System.out.println(Lines.NON_CORRECT);
        }
        carDatabase.removeByPath(from, to);
    }

    void deleteByYear() {
        int from;
        int to;
        while (true) {
            from = enter.year();
            to = enter.year();
            if (!CarUtils.isLess(from, to)) break;
            System.out.println(Lines.NON_CORRECT);
        }
        carDatabase.removeByYear(from, to);
    }

    void deleteAll() {
        carDatabase.removeAll();
    }

}
