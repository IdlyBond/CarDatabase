package mechanics.processor;

import carUtils.CarUtils;
import mechanics.exceptions.CarNotFoundException;

import java.util.HashSet;
import java.util.Set;

class Searcher {

    private Set<Car> carSet;

    Searcher(Set<Car> carSet) {
        this.carSet = carSet;
    }

    Set<Car> vin(String vin) throws CarNotFoundException {
        if (!CarUtils.checkVinCode(vin)) throw new IllegalArgumentException();
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
        if (!CarUtils.checkRegNumber(reg)) throw new IllegalArgumentException();
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
        if (!CarUtils.checkModel(model)) throw new IllegalArgumentException();
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
        if (!CarUtils.checkPrice(from) || !CarUtils.checkPrice(to) || (from > to))
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
        if (!CarUtils.checkPath(from) || !CarUtils.checkPath(to) || (from > to))
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
        if (!CarUtils.checkYear(from) || !CarUtils.checkYear(to) || (from > to))
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
