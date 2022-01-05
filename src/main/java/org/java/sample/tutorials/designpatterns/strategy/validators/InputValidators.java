package org.java.sample.tutorials.designpatterns.strategy.validators;

import java.util.ArrayList;
import java.util.List;

public class InputValidators {
  // Builder to accept the validators
  // Making the validators being invoked in a loop

//  private InputValidators() {
//
//  }
//
//  public static class Builder {
//    public Builder() {
//      // DateStr
//    }
//
//    public Builder(List<Validator> validatorList) {
//      // Filename Validator
//      // OR
//      // JDBC Validator
//    }
//  }
  private List<Validator> validators;

  public void initialiseInputValidators() {
    validators = new ArrayList<>();
    validators.add(new DateValidatorStrategy());
    validators.add(new FilenameValidatorStrategy());

  }

  public boolean executeValidators(String[] request) {
    boolean completed = true;
    for (Validator validator: validators) {
      completed = completed && validator.validate(request);
    }
    return completed;
  }
}
