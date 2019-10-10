package mechanics.exceptions;

public class CarNotFoundException extends Exception {

    private String field;

    public CarNotFoundException(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
