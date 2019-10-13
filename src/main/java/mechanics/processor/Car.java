package mechanics.processor;

import carUtils.CarUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@EqualsAndHashCode
public class Car {

    private String vinCode;
    private String regNumber;
    private String model;
    private int path;
    private int year;
    private int price;

    Car(String vinCode, String regNumber, String model, int path, int year, int price) {
        setVinCode(vinCode);
        setRegNumber(regNumber);
        setModel(model);
        setPath(path);
        setYear(year);
        setPrice(price);

    }

    void setVinCode(final String vinCode) {
        if (!CarUtils.checkVinCode(vinCode)) throw new IllegalArgumentException("Illegal Vin: " + vinCode);
        this.vinCode = vinCode;
    }

    void setRegNumber(final String regNumber) {
        if (!CarUtils.checkRegNumber(regNumber)) throw new IllegalArgumentException("Illegal Reg: " + regNumber);
        this.regNumber = regNumber;
    }

    void setModel(final String model) {
        if (!CarUtils.checkModel(model)) throw new IllegalArgumentException("Illegal Model: " + model);
        this.model = model;
    }

    void setPath(final int path) {
        if (!CarUtils.checkPath(path)) throw new IllegalArgumentException("Illegal Path: " + path);
        this.path = path;
    }

    void setYear(final int year) {
        if (!CarUtils.checkYear(year)) throw new IllegalArgumentException("Illegal Year: " + year);
        this.year = year;
    }

    void setPrice(final int price) {
        if (!CarUtils.checkPrice(price)) throw new IllegalArgumentException("Illegal Price: " + price);
        this.price = price;
    }

    @Override
    public String toString() {
        return "VIN: " + vinCode + '\n' +
                "REG: " + regNumber + '\n' +
                "Model: " + model + '\n' +
                "Path: " + path + '\n' +
                "Year: " + year + '\n' +
                "Price: " + price + '\n';
    }
}
