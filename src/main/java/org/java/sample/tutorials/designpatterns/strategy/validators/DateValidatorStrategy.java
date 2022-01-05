package org.java.sample.tutorials.designpatterns.strategy.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidatorStrategy implements Validator {

  @Override
  public boolean validate(String[] request) {
    boolean complete = true;
    for (DateValidations dateValidations : DateValidations.values()) {
      complete = complete && dateValidations.validate(request[0]);
      if (!complete)
        return complete;
    }
    return complete;
  }

  enum DateValidations {
    IS_EMPTY {
      @Override
      boolean validate(String dateStr) {
        if (dateStr.isBlank() || dateStr.isEmpty()) {
          System.out.println("Please provide a valid date");
          return false;
        }
        return true;
      }
    },

    DATE_FORMAT {
      @Override
      boolean validate(String dateStr) {
        try {
          LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException dateTimeParseEx) {
          System.out.println("Please provide a valid date format, like yyyy-MM-dd");
          return false;
        }
        return true;
      }
    },

    FUTURE_DATE {
      @Override
      boolean validate(String dateStr) {
        try {
          LocalDate givenDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
          if (givenDate.isAfter(LocalDate.now())) {
            System.out.println("Date provided is wrong, the date can't be in future");
            return false;
          }
        } catch (DateTimeParseException dateTimeParseEx) {
          System.out.println("Please provide a valid date format, like yyyy-MM-dd");
          return false;
        }
        return true;
      }
    };

    abstract boolean validate(String dateStr);
  }
}
