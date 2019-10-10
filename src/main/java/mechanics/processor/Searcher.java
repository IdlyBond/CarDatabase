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

    Set<Car> vin(String var) throws CarNotFoundException {
        if (!Checker.checkVinCode(var)) throw new IllegalArgumentException();
        Set<Car> out = new HashSet<>();
        carSet.forEach(car -> {
            if (var.equals(car.getVinCode())) {
                out.add(car);
            }
        });
        return checkOut(out);
    }

    Set<Car> reg(String var) throws CarNotFoundException {
        if (!Checker.checkRegNumber(var)) throw new IllegalArgumentException();
        Set<Car> out = new HashSet<>();
        carSet.forEach(car -> {
            if (var.equals(car.getRegNumber())) {
                out.add(car);
            }
        });
        return checkOut(out);
    }

    Set<Car> model(String var) throws CarNotFoundException {
        if (!Checker.checkModel(var)) throw new IllegalArgumentException();
        Set<Car> out = new HashSet<>();
        carSet.forEach(car -> {
            if (var.equals(car.getModel())) {
                out.add(car);
            }
        });
        return checkOut(out);
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
        return checkOut(out);
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
        return checkOut(out);
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
        return checkOut(out);
    }

    private static Set<Car> checkOut(Set<Car> out) throws CarNotFoundException {
        if (out.isEmpty()) throw new CarNotFoundException();
        return out;
    }


}
