package com.bootcamp.DSCommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO extends CustomErrorDTO{

    private List<FieldMessageError> errors = new ArrayList<>();

    public ValidationErrorDTO(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessageError> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.removeIf(x ->x.getFieldName().equals(fieldName));
        errors.add(new FieldMessageError(fieldName, message));
    }
}
