package processor;

import lombok.Getter;

@Getter
public class CarNotFoundException extends Exception{
    String text;

    public CarNotFoundException(String text) {
        this.text = text;
    }
}
