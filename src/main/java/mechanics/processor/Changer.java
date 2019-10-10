package mechanics.processor;


class Changer {

    void changeVin(final String vin, Car car) {
        car.setVinCode(vin);
    }

    void changeReg(final String reg, Car car) {
        car.setRegNumber(reg);
    }

    void changeModel(final String model, Car car) {
        car.setModel(model);
    }

    void changePrice(final int price, Car car) {
        car.setPrice(price);
    }

    void changePath(final int path, Car car) {
        car.setPath(path);
    }

    void changeYear(final int year, Car car) {
        car.setYear(year);
    }

}
