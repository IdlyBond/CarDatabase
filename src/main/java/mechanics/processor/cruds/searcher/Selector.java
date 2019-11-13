package mechanics.processor.cruds.searcher;

import mechanics.exceptions.CarNotFoundException;
import mechanics.processor.cars.Car;

import java.util.Collection;

public interface Selector {

    Collection<Car> selectByVin(String vin) throws CarNotFoundException;
    Collection<Car> selectByReg(String reg) throws CarNotFoundException;
    Collection<Car> selectByModel(String model) throws CarNotFoundException;
    Collection<Car> selectByPrice(Integer from, Integer to) throws CarNotFoundException;
    Collection<Car> selectByPath(Integer from, Integer to) throws CarNotFoundException;
    Collection<Car> selectByYear(Integer from, Integer to) throws CarNotFoundException;
    Collection<Car> selectAll() throws CarNotFoundException;

}
