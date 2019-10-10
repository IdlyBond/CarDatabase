package mechanics.processor;

import mechanics.exceptions.CarNotFoundException;
import utillities.Checker;

import java.util.HashSet;
import java.util.Set;

public class CarDatabase {

    private Set<Car> carsList = new HashSet<>();
    private Searcher searcher = new Searcher(carsList);

    public void add(String vinCode, String regNumber, String model, int path, int year, int price) {
        carsList.add(new Car(vinCode, regNumber, model, path, year, price));
    }

    public void removeByVin(final String vin) {
        carsList.removeIf(v -> v.getVinCode().equals(vin));
    }

    public void removeByReg(final String reg) {
        carsList.removeIf(v -> v.getRegNumber().equals(reg));
    }

    public void removeByModel(final String model) {
        carsList.removeIf(v -> v.getModel().equals(model));
    }

    public void removeByPrice(final int from, final int to) {
        if (Checker.isLess(from, to)) throw new IllegalArgumentException(from + " < " + to);
        carsList.removeIf(v -> v.getPrice() >= from && v.getPrice() <= to);
    }

    public void removeByPath(final int from, final int to) {
        if (Checker.isLess(from, to)) throw new IllegalArgumentException(from + " < " + to);
        carsList.removeIf(v -> v.getPath() >= from && v.getPath() <= to);
    }

    public void removeByYear(final int from, final int to) {
        if (Checker.isLess(from, to)) throw new IllegalArgumentException(from + " < " + to);
        carsList.removeIf(v -> v.getYear() >= from && v.getYear() <= to);
    }

    public void removeAll() {
        for (Car car : carsList) {
            carsList.remove(car);
        }
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
