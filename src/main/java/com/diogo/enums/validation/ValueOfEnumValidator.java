package com.diogo.enums.validation;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum, CharSequence>{

    private List<String> acceptedValues;

    @Override
    public void initialize(ValueOfEnum annoation) {
        acceptedValues = Stream.of(annoation.enumClass().getEnumConstants())
        .map(Enum::toString)
        .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return acceptedValues.contains(value.toString());
    }

}
