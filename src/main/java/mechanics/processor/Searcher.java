package mechanics.processor;

import mechanics.exceptions.CarNotFoundException;
import utillities.Checker;

import java.util.HashSet;
import java.util.Set;

class Searcher {

    private Set<Car> carSet;

    Searcher(Set<Car> carSet) {
        this.carSet = carSet;
    }

    Set<Car> vin(String vin) throws CarNotFoundException {
        if (!Checker.checkVinCode(vin)) throw new IllegalArgumentException();
        Set<Car> out = new HashSet<>();
        carSet.forEach(car -> {
            if (vin.equals(car.getVinCode())) {
                out.add(car);
            }
        });
        if (out.isEmpty()) throw new CarNotFoundException(vin);
        return out;
    }

    Set<Car> reg(String reg) throws CarNotFoundException {
        if (!Checker.checkRegNumber(reg)) throw new IllegalArgumentException();
        Set<Car> out = new HashSet<>();
        carSet.forEach(car -> {
            if (reg.equals(car.getRegNumber())) {
                out.add(car);
            }
        });
        if (out.isEmpty()) throw new CarNotFoundException(reg);
        return out;
    }

    Set<Car> model(String model) throws CarNotFoundException {
        if (!Checker.checkModel(model)) throw new IllegalArgumentException();
        Set<Car> out = new HashSet<>();
        carSet.forEach(car -> {
            if (model.equals(car.getModel())) {
                out.add(car);
            }
        });
        if (out.isEmpty()) throw new CarNotFoundException(model);
        return out;
    }

    Set<Car> price(Integer from, Integer to) throws CarNotFoundException {
        if (!Checker.checkPrice(from) || !Checker.checkPrice(to) || (from > to))
            throw new IllegalArgumentException("Illegal Price");
        Set<Car> out = new HashSet<>();
        carSet.forEach(car -> {
            if (car.getPrice() >= from && car.getPrice() <= to) {
                out.add(car);
            }
        });
        if (out.isEmpty()) throw new CarNotFoundException(from + "-" + to);
        return out;
    }

    Set<Car> path(Integer from, Integer to) throws CarNotFoundException {
        if (!Checker.checkPath(from) || !Checker.checkPath(to) || (from > to))
            throw new IllegalArgumentException("Illegal Path");
        Set<Car> out = new HashSet<>();
        carSet.forEach(car -> {
            if (car.getPath() >= from && car.getPath() <= to) {
                out.add(car);
            }
        });
        if (out.isEmpty()) throw new CarNotFoundException(from + "-" + to);
        return out;
    }

    Set<Car> year(Integer from, Integer to) throws CarNotFoundException {
        if (!Checker.checkYear(from) || !Checker.checkYear(to) || (from > to))
            throw new IllegalArgumentException("Illegal Year");
        Set<Car> out = new HashSet<>();
        carSet.forEach(car -> {
            if (car.getYear() >= from && car.getYear() <= to) {
                out.add(car);
            }
        });
        if (out.isEmpty()) throw new CarNotFoundException(from + "-" + to);
        return out;
    }


}
