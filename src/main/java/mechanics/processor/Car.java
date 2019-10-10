package mechanics.processor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import utillities.Checker;


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

    public void setVinCode(final String vinCode) {
        if (!Checker.checkVinCode(vinCode)) throw new IllegalArgumentException("Illegal Vin");
        this.vinCode = vinCode;
    }

    public void setRegNumber(final String regNumber) {
        if (!Checker.checkRegNumber(regNumber)) throw new IllegalArgumentException("Illegal Reg");
        this.regNumber = regNumber;
    }

    public void setModel(final String model) {
        if (!Checker.checkModel(model)) throw new IllegalArgumentException("Illegal Model");
        this.model = model;
    }

    public void setPath(final int path) {
        if (!Checker.checkPath(path)) throw new IllegalArgumentException("Illegal Path");
        this.path = path;
    }

    public void setYear(final int year) {
        if (!Checker.checkYear(year)) throw new IllegalArgumentException("Illegal Year");
        this.year = year;
    }

    public void setPrice(final int price) {
        if (!Checker.checkPrice(price)) throw new IllegalArgumentException("Illegal Price");
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
