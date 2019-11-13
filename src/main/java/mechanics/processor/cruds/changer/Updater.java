package mechanics.processor.cruds.changer;

import mechanics.processor.cars.Car;

public interface Updater {

    void changeVin(final String vin, Car car);
    void changeReg(final String reg, Car car);
    void changeModel(final String model, Car car);
    void changePrice(final int price, Car car);
    void changePath(final int path, Car car);
    void changeYear(final int year, Car car);

}
