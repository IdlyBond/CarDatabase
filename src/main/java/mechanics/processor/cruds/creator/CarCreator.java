package mechanics.processor.cruds.creator;

import mechanics.processor.cars.Car;

import java.util.Collection;

public class CarCreator implements Creator {

    private Collection<Car> cars;

    public CarCreator(Collection<Car> cars) {
        this.cars = cars;
    }

    @Override
    public void insert(String vinCode, String regNumber, String model, int path, int year, int price) {
        cars.add(new Car(vinCode, regNumber, model, path, year, price));
    }

}
