package processor;

import cars.Car;
import constants.Fields;
import constants.Lines;

import java.util.HashSet;
import java.util.Set;

public class CarCollector {

    private Set<Car> carsList = new HashSet<>();
    private Searcher searcher = new Searcher(carsList);

    public void add(String vinCode, String regNumber, String model, int path, int year, int price){
        carsList.add(new Car(vinCode, regNumber, model, path, year, price));
    }

    public void removeByVin(String vin){
        carsList.removeIf(v -> v.getVinCode().equals(vin));
    }

    public Set<Car> search(final String var, Fields field){
        return searcher.find(var, field);
    }

    public Set<Car> search(final Integer from, final Integer to, Fields field) {
        return searcher.find(from, to, field);
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("Все машины:\n");
        carsList.forEach((v -> line.append("* \n").append(v).append("\n")));
        return line.toString();
    }

    public CarCollector() {
        //Машины по умолчанию, для наглядности
        Car car1 = new Car(Lines.DEFAULT_VIN_1.getLine(), Lines.DEFAULT_REG_NUM_1.getLine(), Lines.DEFAULT_MODEL_1.getLine(),
                500, 2000, 1000);
        Car car2 = new Car(Lines.DEFAULT_VIN_2.getLine(), Lines.DEFAULT_REG_NUM_2.getLine(), Lines.DEFAULT_MODEL_2.getLine(),
                600, 2006, 1300);
        Car car3 = new Car(Lines.DEFAULT_VIN_3.getLine(), Lines.DEFAULT_REG_NUM_3.getLine(), Lines.DEFAULT_MODEL_3.getLine(),
                1500, 1995, 500);
        Car car4 = new Car(Lines.DEFAULT_VIN_4.getLine(), Lines.DEFAULT_REG_NUM_4.getLine(), Lines.DEFAULT_MODEL_4.getLine(),
                50, 2019, 3000);
        this.carsList.add(car1);
        this.carsList.add(car2);
        this.carsList.add(car3);
        this.carsList.add(car4);
    }
}
