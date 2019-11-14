package mechanics.processor;

import mechanics.exceptions.CarNotFoundException;
import mechanics.processor.cars.Car;
import mechanics.processor.cruds.changer.Changer;
import mechanics.processor.cruds.changer.Updater;
import mechanics.processor.cruds.creator.CarCreator;
import mechanics.processor.cruds.creator.Creator;
import mechanics.processor.cruds.remover.Remover;
import mechanics.processor.cruds.remover.SimpleRemover;
import mechanics.processor.cruds.saver.InteractingCSV;
import mechanics.processor.cruds.saver.FileInteractive;
import mechanics.processor.cruds.searcher.Searcher;
import mechanics.processor.cruds.searcher.Selector;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class CarCRUD implements CRUD, Serializable {

    private static CarCRUD instance;
    private Collection<Car> cars;
    private Creator creator;
    private Selector selector;
    private Remover remover;
    private Updater updater;
    private FileInteractive<Car> fileData; //TODO

    public void insert(String vinCode, String regNumber, String model, int path, int year, int price) {
        creator.insert(vinCode, regNumber, model, path, year, price);
    }

    @Override
    public void removeByVin(final String vin) throws CarNotFoundException {
        remover.removeByVin(vin);
    }

    @Override
    public void removeByReg(final String reg) throws CarNotFoundException {
        remover.removeByReg(reg);
    }

    @Override
    public void removeByModel(final String model) throws CarNotFoundException {
        remover.removeByModel(model);
    }

    @Override
    public void removeByPrice(final int from, final int to) throws CarNotFoundException {
        remover.removeByPrice(from, to);
    }

    @Override
    public void removeByPath(final int from, final int to) throws CarNotFoundException {
        remover.removeByPath(from, to);
    }

    @Override
    public void removeByYear(final int from, final int to) throws CarNotFoundException {
        remover.removeByYear(from, to);
    }

    @Override
    public void removeAll() throws CarNotFoundException {
        remover.removeAll();
    }

    @Override
    public void changeVin(final String vin, Car car) {
        updater.changeVin(vin, car);
    }

    @Override
    public void changeReg(final String reg, Car car) {
        updater.changeReg(reg, car);
    }

    @Override
    public void changeModel(final String model, Car car) {
        updater.changeModel(model, car);
    }

    @Override
    public void changePrice(final int price, Car car) {
        updater.changePrice(price, car);
    }

    public void changePath(final int path, Car car) {
        updater.changePath(path, car);
    }

    @Override
    public void changeYear(final int year, Car car) {
        updater.changeYear(year, car);
    }

    @Override
    public Collection<Car> selectByVin(final String line) throws CarNotFoundException {

        return selector.selectByVin(line);
    }

    @Override
    public Collection<Car> selectByReg(final String line) throws CarNotFoundException {
        return selector.selectByReg(line);
    }

    @Override
    public Collection<Car> selectByModel(final String line) throws CarNotFoundException {
        return selector.selectByModel(line);
    }

    @Override
    public Collection<Car> selectByPath(final Integer from, final Integer to) throws CarNotFoundException {
        return selector.selectByPath(from, to);
    }

    @Override
    public Collection<Car> selectByPrice(final Integer from, final Integer to) throws CarNotFoundException {
        return selector.selectByPrice(from, to);
    }

    @Override
    public Collection<Car> selectByYear(final Integer from, final Integer to) throws CarNotFoundException {
        return selector.selectByYear(from, to);
    }

    @Override
    public Collection<Car> selectAll() throws CarNotFoundException {
        return selector.selectAll();
    }

/*    private void updateFile(){ TODO
        try {
            fileData.save(cars);
        } catch (IOException e) {
            throw new RuntimeException("Could not save data to file: " + e.getMessage());
        }
    }

    private void readCars(){ TODO
        try {
            fileData.read(cars, Car.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public boolean isEmpty() {
        return cars.isEmpty();
    }

    private CarCRUD() {
        cars = new HashSet<>();
        fileData = new InteractingCSV<>();
        selector = new Searcher(cars);
        creator = new CarCreator(cars);
        remover = new SimpleRemover(cars);
        updater = new Changer();
    }

    public static CarCRUD getInstance() {
        if (Objects.isNull(instance)) instance = new CarCRUD();
        return instance;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("Все машины:\n");
        cars.forEach((v -> line.append("* \n").append(v).append("\n")));
        return line.toString();
    }
}
