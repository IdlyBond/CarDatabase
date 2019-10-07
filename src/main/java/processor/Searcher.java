package processor;

import cars.Car;
import constants.Fields;
import cars.InvalidInputException;
import utillities.Checker;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Searcher {

    Set<Car> carSet;

    public Searcher(Set<Car> carSet) {
        this.carSet = carSet;
    }

    public Set<Car> find(String value, Fields field){
        if(Objects.isNull(field) || Objects.isNull(value)) return Collections.emptySet();
        Set<Car> out = new HashSet<>();
        switch (field){
            case VIN_CODE:
                if(!Checker.checkVinCode(value)) throw new InvalidInputException(field);
                return searchVin(value.trim(), out);
            case REG_NUM:
                if(!Checker.checkRegNumber(value)) throw new InvalidInputException(field);
                return searchReg(value.trim(), out);
            case MODEL:
                if(!Checker.checkModel(value)) throw new InvalidInputException(field);
                return searchModel(value.trim(), out);
            default: return Collections.emptySet();
        }
    }

    public Set<Car> find(int from, int to, Fields field){
        if(Objects.isNull(field)) return Collections.emptySet();
        if (to < from) throw new InvalidInputException(field);
        Set<Car> out = new HashSet<>();
        switch (field){
            case PRICE:
                if(!Checker.checkPrice(from) || !Checker.checkPrice(to)) throw new InvalidInputException(field);
                return searchPrice(from, to, out);
            case PATH:
                if(!Checker.checkPath(from) || !Checker.checkPath(to)) throw new InvalidInputException(field);
                return searchPath(from, to, out);
            case YEAR:
                if(!Checker.checkYear(from) || !Checker.checkYear(to)) throw new InvalidInputException(field);
                return searchYear(from, to, out);
            default: return Collections.emptySet();
        }
    }

    private Set<Car> searchVin(String var, Set<Car> out){
        carSet.forEach(car -> { if(var.equals(car.getVinCode())){ out.add(car); }});
        return out.isEmpty()? Collections.emptySet(): out;
    }

    private Set<Car> searchReg(String var, Set<Car> out){
        carSet.forEach(car -> { if(var.equals(car.getRegNumber())){ out.add(car); }});
        return out.isEmpty()? Collections.emptySet(): out;
    }

    private Set<Car> searchModel(String var, Set<Car> out){
        carSet.forEach(car -> { if(var.equals(car.getModel())){ out.add(car); }});
        return out.isEmpty()? Collections.emptySet(): out;
    }

    private Set<Car> searchPrice(Integer from, Integer to, Set<Car> out){
        carSet.forEach(car -> { if(car.getPrice() >= from && car.getPrice() <= to){ out.add(car); }});
        return out.isEmpty()? Collections.emptySet(): out;
    }

    private Set<Car> searchPath(Integer from, Integer to, Set<Car> out){
        carSet.forEach(car -> { if(car.getPath() >= from && car.getPath() <= to){ out.add(car); }});
        return out.isEmpty()? Collections.emptySet(): out;
    }

    private Set<Car> searchYear(Integer from, Integer to, Set<Car> out){
        carSet.forEach(car -> { if(car.getYear() >= from && car.getYear() <= to){ out.add(car); }});
        return out.isEmpty()? Collections.emptySet(): out;
    }


}
