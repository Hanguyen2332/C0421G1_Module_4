package com.practice.model.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PhoneNumberDto implements Validator {
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneNumberDto phoneNumberDto = (PhoneNumberDto) target;
        String number = phoneNumberDto.getNumber();
        if (!number.startsWith("0")) {
            errors.rejectValue("number", "number.startWithZero", "phone number must be start with 0");
        }
        if (number.length() > 11 || number.length() < 10) {
            errors.rejectValue("number", "number.length", "phone number must have 10 or 11 digit");
        }
        if (number.matches("^[a-zA-Z]+$")) {
            errors.rejectValue("number", "number.containLetter", "phone number NOT contain letter");
        }
    }
}
