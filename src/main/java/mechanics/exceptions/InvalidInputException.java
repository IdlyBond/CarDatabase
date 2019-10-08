package mechanics.exceptions;

import constants.Fields;

public class InvalidInputException extends RuntimeException{

    private Fields field;

    public InvalidInputException(Fields field) {
        this.field = field;
    }

    public Fields getField() {
        return field;
    }
}
