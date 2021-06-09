package com.digitalhouse.obtenerdiploma.execptionHandler;

public class ValidationError {

    String Field;
    String Message;

    public ValidationError(String field, String message) {
        Field = field;
        Message = message;
    }

    public String getField() {
        return Field;
    }

    public void setField(String field) {
        Field = field;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
