package mechanics.processor.cars;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import utils.CarUtils;

import java.io.Serializable;


@Getter
@EqualsAndHashCode
public class Car implements Serializable {


    private String vinCode;
    private String regNumber;
    private String model;
    private int path;
    private int year;
    private int price;

    public Car(@JsonProperty("vin") String vinCode, @JsonProperty("reg") String regNumber, @JsonProperty("model") String model, @JsonProperty("path") int path, @JsonProperty("year") int year, @JsonProperty("price") int price) {
        setVinCode(vinCode);
        setRegNumber(regNumber);
        setModel(model);
        setPath(path);
        setYear(year);
        setPrice(price);
    }

    public void setVinCode(final String vinCode) {
        if (!CarUtils.checkVinCode(vinCode)) throw new IllegalArgumentException("Illegal Vin: " + vinCode);
        this.vinCode = vinCode;
    }

    public void setRegNumber(final String regNumber) {
        if (!CarUtils.checkRegNumber(regNumber)) throw new IllegalArgumentException("Illegal Reg: " + regNumber);
        this.regNumber = regNumber;
    }

    public void setModel(final String model) {
        if (!CarUtils.checkModel(model)) throw new IllegalArgumentException("Illegal Model: " + model);
        this.model = model;
    }

    public void setPath(final int path) {
        if (!CarUtils.checkPath(path)) throw new IllegalArgumentException("Illegal Path: " + path);
        this.path = path;
    }

    public void setYear(final int year) {
        if (!CarUtils.checkYear(year)) throw new IllegalArgumentException("Illegal Year: " + year);
        this.year = year;
    }

    public void setPrice(final int price) {
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
