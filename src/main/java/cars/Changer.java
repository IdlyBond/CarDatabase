package cars;

import constants.Fields;
import utillities.Checker;

public class Changer {

    public void change(String value, Fields field, Car car){
        switch (field){
            case VIN_CODE:
                if(!Checker.checkVinCode(value)) throw new InvalidInputException(field);
                car.setVinCode(value);
                break;
            case REG_NUM:
                if(!Checker.checkRegNumber(value)) throw new InvalidInputException(field);
                car.setRegNumber(value);
                break;
            case MODEL:
                if(!Checker.checkModel(value)) throw new InvalidInputException(field);
                car.setModel(value);
                break;
        }
    }

    public void change(int value, Fields field, Car car){
        switch (field){
            case PRICE:
                if(!Checker.checkPrice(value)) throw new InvalidInputException(field);
                car.setPrice(value);
                break;
            case PATH:
                if(!Checker.checkPath(value)) throw new InvalidInputException(field);
                car.setPath(value);
                break;
            case YEAR:
                if(!Checker.checkYear(value)) throw new InvalidInputException(field);
                car.setYear(value);
                break;
        }
    }
}
