package mechanics.processor;

import mechanics.exceptions.CarNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class CarDatabase {

    private Set<Car> carsList = new HashSet<>();
    private Searcher searcher = new Searcher(carsList);
    private Remover remover = new Remover(carsList);
    private Changer changer = new Changer();

    public void add(String vinCode, String regNumber, String model, int path, int year, int price) {
        carsList.add(new Car(vinCode, regNumber, model, path, year, price));
    }

    public void removeByVin(final String vin) {
        remover.removeByVin(vin);
    }

    public void removeByReg(final String reg) {
        remover.removeByReg(reg);
    }

    public void removeByModel(final String model) {
        remover.removeByModel(model);
    }

    public void removeByPrice(final int from, final int to) {
        remover.removeByPrice(from, to);
    }

    public void removeByPath(final int from, final int to) {
        remover.removeByPath(from, to);
    }

    public void removeByYear(final int from, final int to) {
        remover.removeByYear(from, to);
    }

    public void removeAll() {
        carsList.clear();
    }

    public void changeVin(final String vin, Car car) {
        changer.changeReg(vin, car);
    }

    public void changeReg(final String reg, Car car) {
        changer.changeReg(reg, car);
    }

    public void changeModel(final String model, Car car) {
        changer.changeModel(model, car);
    }

    public void changePrice(final int price, Car car) {
        changer.changePrice(price, car);
    }

    public void changePath(final int path, Car car) {
        changer.changePath(path, car);
    }

    public void changeYear(final int year, Car car) {
        changer.changeYear(year, car);
    }

    public Set<Car> searchByVin(final String line) throws CarNotFoundException {
        return searcher.vin(line);
    }

    public Set<Car> searchByReg(final String line) throws CarNotFoundException {
        return searcher.reg(line);
    }

    public Set<Car> searchByModel(final String line) throws CarNotFoundException {
        return searcher.model(line);
    }

    public Set<Car> searchByPath(final Integer from, final Integer to) throws CarNotFoundException {
        return searcher.path(from, to);
    }

    public Set<Car> searchByPrice(final Integer from, final Integer to) throws CarNotFoundException {
        return searcher.price(from, to);
    }

    public Set<Car> searchByYear(final Integer from, final Integer to) throws CarNotFoundException {
        return searcher.year(from, to);
    }

    public boolean isEmpty() {
        return carsList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("Все машины:\n");
        carsList.forEach((v -> line.append("* \n").append(v).append("\n")));
        return line.toString();
    }
}
