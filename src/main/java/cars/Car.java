package cars;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import utillities.Checker;
import constants.Fields;


@Getter
@EqualsAndHashCode
public class Car {

    private String vinCode;
    private String regNumber;
    private String model;
    private int path;
    private int year;
    private int price;

    public Car(String vinCode, String regNumber, String model, int path, int year, int price) {
        setVinCode(vinCode);
        setRegNumber(regNumber);
        setModel(model);
        setPath(path);
        setYear(year);
        setPrice(price);
    }

    protected void setVinCode(final String vinCode){
        if (!Checker.checkVinCode(vinCode)) throw new InvalidInputException(Fields.VIN_CODE);
        this.vinCode = vinCode;
    }

    protected void setRegNumber(final String regNumber) {
        if (!Checker.checkRegNumber(regNumber)) throw new InvalidInputException(Fields.REG_NUM);
        this.regNumber = regNumber;
    }

    protected void setModel(final String model) {
        if (!Checker.checkModel(model)) throw new InvalidInputException(Fields.MODEL);
        this.model = model;
    }

    protected void setPath(final int path) {
        if (!Checker.checkPath(path)) throw new InvalidInputException(Fields.PATH);
        this.path = path;
    }

    protected void setYear(final int year) {
        if (!Checker.checkYear(year)) throw new InvalidInputException(Fields.YEAR);
        this.year = year;
    }

    protected void setPrice(final int price) {
        if (!Checker.checkPrice(price)) throw new InvalidInputException(Fields.PRICE);
        this.price = price;
    }

    @Override
    public String toString() {
        return  "VIN: " + vinCode + '\n' +
                "REG: " + regNumber + '\n' +
                "Model: " + model + '\n' +
                "Path: " + path + '\n' +
                "Year: " + year + '\n' +
                "Price: " + price + '\n';
    }
}
