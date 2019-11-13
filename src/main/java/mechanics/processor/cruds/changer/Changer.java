package mechanics.processor.cruds.changer;

import mechanics.processor.cars.Car;

public class Changer implements Updater{

    @Override
    public void changeVin(final String vin, Car car) {
        car.setVinCode(vin);
    }

    @Override
    public void changeReg(final String reg, Car car) {
        car.setRegNumber(reg);
    }

    @Override
    public void changeModel(final String model, Car car) {
        car.setModel(model);
    }

    @Override
    public void changePrice(final int price, Car car) {
        car.setPrice(price);
    }

    @Override
    public void changePath(final int path, Car car) {
        car.setPath(path);
    }

    @Override
    public void changeYear(final int year, Car car) {
        car.setYear(year);
    }

}
