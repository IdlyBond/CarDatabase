package mechanics.facade;

import mechanics.exceptions.CarNotFoundException;
import mechanics.processor.cars.Car;

import java.util.Collection;

public interface Database {
    Collection<Car> select(String value, DataTypes type) throws CarNotFoundException;
    Collection<Car> select(int from, int to, DataTypes type) throws CarNotFoundException;
    Collection<Car> select() throws CarNotFoundException;
    void update(String vinCode, String regNumber, String model, int path, int year, int price);
    void update(String value, Car car, DataTypes type);
    void update(int value, Car car, DataTypes type);
    void delete(String value, DataTypes type) throws CarNotFoundException;
    void delete(int from, int to, DataTypes type) throws CarNotFoundException;
    void delete() throws CarNotFoundException;
}
