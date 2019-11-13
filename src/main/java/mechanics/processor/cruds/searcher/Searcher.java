package mechanics.processor.cruds.searcher;

import mechanics.exceptions.CarNotFoundException;
import mechanics.processor.cars.Car;
import utils.CarUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Searcher implements Selector{

    private Collection<Car> cars;

    public Searcher(Collection<Car> cars) {
        this.cars = cars;
    }

    @Override
    public Collection<Car> selectByVin(String vin) throws CarNotFoundException {
        if (!CarUtils.checkVinCode(vin)) throw new IllegalArgumentException();
        Set<Car> out = new HashSet<>();
        cars.forEach(car -> {
            if (vin.equals(car.getVinCode())) {
                out.add(car);
            }
        });
        if (out.isEmpty()) throw new CarNotFoundException(vin);
        return out;
    }

    @Override
    public Collection<Car> selectByReg(String reg) throws CarNotFoundException {
        if (!CarUtils.checkRegNumber(reg)) throw new IllegalArgumentException();
        Set<Car> out = new HashSet<>();
        cars.forEach(car -> {
            if (reg.equals(car.getRegNumber())) {
                out.add(car);
            }
        });
        if (out.isEmpty()) throw new CarNotFoundException(reg);
        return out;
    }

    @Override
    public Collection<Car> selectByModel(String model) throws CarNotFoundException {
        if (!CarUtils.checkModel(model)) throw new IllegalArgumentException();
        Set<Car> out = new HashSet<>();
        cars.forEach(car -> {
            if (model.equals(car.getModel())) {
                out.add(car);
            }
        });
        if (out.isEmpty()) throw new CarNotFoundException(model);
        return out;
    }

    @Override
    public Collection<Car> selectByPrice(Integer from, Integer to) throws CarNotFoundException {
        if (!CarUtils.checkPrice(from) || !CarUtils.checkPrice(to) || (from > to))
            throw new IllegalArgumentException("Illegal Price");
        Set<Car> out = new HashSet<>();
        cars.forEach(car -> {
            if (car.getPrice() >= from && car.getPrice() <= to) {
                out.add(car);
            }
        });
        if (out.isEmpty()) throw new CarNotFoundException(from + "-" + to);
        return out;
    }

    @Override
    public Collection<Car> selectByPath(Integer from, Integer to) throws CarNotFoundException {
        if (!CarUtils.checkPath(from) || !CarUtils.checkPath(to) || (from > to))
            throw new IllegalArgumentException("Illegal Path");
        Set<Car> out = new HashSet<>();
        cars.forEach(car -> {
            if (car.getPath() >= from && car.getPath() <= to) {
                out.add(car);
            }
        });
        if (out.isEmpty()) throw new CarNotFoundException(from + "-" + to);
        return out;
    }

    @Override
    public Collection<Car> selectByYear(Integer from, Integer to) throws CarNotFoundException {
        if (!CarUtils.checkYear(from) || !CarUtils.checkYear(to) || (from > to))
            throw new IllegalArgumentException("Illegal Year");
        Set<Car> out = new HashSet<>();
        cars.forEach(car -> {
            if (car.getYear() >= from && car.getYear() <= to) {
                out.add(car);
            }
        });
        if (out.isEmpty()) throw new CarNotFoundException(from + "-" + to);
        return out;
    }

    @Override
    public Collection<Car> selectAll() throws CarNotFoundException {
        return cars;
    }


}
