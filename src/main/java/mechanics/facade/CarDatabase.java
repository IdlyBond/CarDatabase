package mechanics.facade;

import mechanics.exceptions.CarNotFoundException;
import mechanics.processor.CRUD;
import mechanics.processor.CarCRUD;
import mechanics.processor.cars.Car;

import java.util.Collection;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarDatabase implements Database {

    private static CarDatabase instance;
    private CRUD crud;
    private Logger log;

    public static CarDatabase getInstance(){
        if(Objects.isNull(instance)) instance = new CarDatabase();
        return instance;
    }

    private CarDatabase() {
        crud = CarCRUD.getInstance();
        log = Logger.getLogger(CarDatabase.class.getName());
    }


    @Override
    public Collection<Car> select(String value, DataTypes type) throws CarNotFoundException {
        if (Objects.isNull(value) || Objects.isNull(type)) throw new NullPointerException("Value " + value + " and Type " + type + " should not be NULL");
        try {
        switch (type) {
            case VIN:
                log.log(Level.INFO, "Try to find car with {0} {1}...", new String[]{type.name(), value});
                return crud.selectByVin(value);
            case REG:
                log.log(Level.INFO, "Try to find car with {0} {1}...", new String[]{type.name(), value});
                return crud.selectByReg(value);
            case MODEL:
                log.log(Level.INFO, "Try to find car with {0} {1}...", new String[]{type.name(), value});
                return crud.selectByModel(value);
            default:
                throw new IllegalArgumentException("Type must be VIN, REG or MODEL, your is " + type);
        }
        } catch (CarNotFoundException e) {
            log.log(Level.INFO, "Car with {0} {1} was not found", new String[]{type.name(), value});
            throw e;
        }
    }

    @Override
    public Collection<Car> select(int from, int to, DataTypes type) throws CarNotFoundException{
        if (Objects.isNull(type)) throw new NullPointerException("Type should not be NULL");
        try {
            switch (type) {
                case PRICE:
                    log.log(Level.INFO, "Try to find car with {0} from {1} to {2}...",
                            new String[]{type.name(), String.valueOf(from), String.valueOf(to)});
                    return crud.selectByPrice(from, to);
                case PATH:
                    log.log(Level.INFO, "Try to find car with {0} from {1} to {2}...",
                            new String[]{type.name(), String.valueOf(from), String.valueOf(to)});
                    return crud.selectByPath(from, to);
                case YEAR:
                    log.log(Level.INFO, "Try to find car with {0} from {1} to {2}...",
                            new String[]{type.name(), String.valueOf(from), String.valueOf(to)});
                    return crud.selectByYear(from, to);
                default:
                    throw new IllegalArgumentException("Type must be PRICE, PATH or YEAR, your is " + type);
            }
        } catch (CarNotFoundException e) {
            log.log(Level.INFO, "Car with {0} from {1} to {2} was not found",
                    new String[]{type.name(), String.valueOf(from), String.valueOf(to)});
            throw e;
        }
    }

    @Override
    public Collection<Car> select() throws CarNotFoundException {
        try {
            log.info("Try to select all cars");
            return crud.selectAll();
        } catch (CarNotFoundException e) {
            log.info("No cars at all");
            throw e;
        }
    }

    @Override
    public void update(String vinCode, String regNumber, String model, int path, int year, int price) {
        crud.insert(vinCode, regNumber, model, path, year, price);
        log.log(Level.INFO, "Car with vin {0}, reg {1}, model {2}, path {3}, year {4}, price {5} was added",
                new String[] {vinCode, regNumber, model, String.valueOf(path), String.valueOf(year), String.valueOf(price)});
    }

    @Override
    public void update(String value, Car car, DataTypes type) {
        if (Objects.isNull(value) || Objects.isNull(type))
            throw new NullPointerException("Value " + value + " and Type " + type + " should not be NULL");
        switch (type) {
            case VIN:
                log.log(Level.INFO, "Try to change {0} of car with VIN {1} from {2} to {3}...",
                        new String[]{type.name(), car.getVinCode(), car.getVinCode(), value});
                crud.changeVin(value, car);
                break;
            case REG:
                log.log(Level.INFO, "Try to change {0} of car with VIN {1} from {2} to {3}...",
                        new String[]{type.name(), car.getVinCode(), car.getRegNumber(), value});
                crud.changeReg(value, car);
                break;
            case MODEL:
                log.log(Level.INFO, "Try to change {0} of car with VIN {1} from {2} to {3}...",
                        new String[]{type.name(), car.getVinCode(), car.getModel(), value});
                crud.changeModel(value, car);
                break;
            default:
                throw new IllegalArgumentException("Type must be VIN, REG or MODEL, your is " + type);
        }
    }

    @Override
    public void update(int value, Car car, DataTypes type) {
        if (Objects.isNull(type)) throw new NullPointerException("Type should not be NULL");
        switch (type) {
            case PRICE:
                log.log(Level.INFO, "Try to change {0} of car with VIN {1} from {2} to {3}...",
                        new String[]{type.name(), car.getVinCode(), car.getVinCode(), String.valueOf(value)});
                crud.changePrice(value, car);
                break;
            case PATH:
                log.log(Level.INFO, "Try to change {0} of car with VIN {1} from {2} to {3}...",
                        new String[]{type.name(), car.getVinCode(), car.getVinCode(), String.valueOf(value)});
                crud.changePath(value, car);
                break;
            case YEAR:
                log.log(Level.INFO, "Try to change {0} of car with VIN {1} from {2} to {3}...",
                        new String[]{type.name(), car.getVinCode(), car.getVinCode(), String.valueOf(value)});
                crud.changeYear(value, car);
                break;
            default:
                throw new IllegalArgumentException("Type must be PRICE, PATH or YEAR, your is " + type);
        }
    }

    @Override
    public void delete(String value, DataTypes type) throws CarNotFoundException {
        if (Objects.isNull(value) || Objects.isNull(type)) throw new NullPointerException("Value " + value + " and Type " + type + " should not be NULL");
        try {
            switch (type) {
                case VIN:
                    log.log(Level.INFO, "Try to remove car with {0} {1}...",
                            new String[]{type.name(), value});
                    crud.removeByVin(value);
                    break;
                case REG:
                    log.log(Level.INFO, "Try to remove car with {0} {1}...",
                            new String[]{type.name(), value});
                    crud.removeByReg(value);
                    break;
                case MODEL:
                    log.log(Level.INFO, "Try to remove car with {0} {1}...",
                            new String[]{type.name(), value});
                    crud.removeByModel(value);
                    break;
                default:
                    throw new IllegalArgumentException("Type must be VIN, REG or MODEL, your is " + type);
            }
        } catch (CarNotFoundException e) {
            log.log(Level.INFO, "Car with {0} {1} has no been deleted because it does not exist",
                    new String[]{type.name(), value});
            throw e;
        }
    }

    @Override
    public void delete(int from, int to, DataTypes type) throws CarNotFoundException {
        if (Objects.isNull(type)) throw new NullPointerException("Type should not be NULL");
        try {
        switch (type) {
            case PRICE:
                log.log(Level.INFO, "Try to remove car with {0} from {1} to {2}...",
                        new String[]{type.name(), String.valueOf(from), String.valueOf(to)});
                crud.removeByPrice(from, to);
                break;
            case PATH:
                log.log(Level.INFO, "Try to remove car with {0} from {1} to {2}...",
                        new String[]{type.name(), String.valueOf(from), String.valueOf(to)});
                crud.removeByPath(from, to);
                break;
            case YEAR:
                log.log(Level.INFO, "Try to remove car with {0} from {1} to {2}...",
                        new String[]{type.name(), String.valueOf(from), String.valueOf(to)});
                crud.removeByYear(from, to);
                break;
            default:
                throw new IllegalArgumentException("Type must be PRICE, PATH or YEAR, your is " + type);
        }
        } catch (CarNotFoundException e) {
            log.log(Level.INFO, "Car with {0} from {1} to {2} has no been deleted because it does not exist",
                    new String[]{type.name(), String.valueOf(from), String.valueOf(to)});
            throw e;
        }
    }

    @Override
    public void delete() throws CarNotFoundException {
        try {
            log.info("Try to delete all cars");
            crud.removeAll();
        } catch (CarNotFoundException e) {
            log.info("There are no cars in database");
            throw e;
        }
    }
}
