package org.java.sample.tutorials.designpatterns.strategy;

import org.java.sample.tutorials.designpatterns.strategy.validators.InputValidators;

public class ValidateCookieDataStrategy {

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Please provide valid args for processing browser cookies");
      System.exit(1);
    }

    InputValidators inputValidators = new InputValidators();
    inputValidators.initialiseInputValidators();
    if (!inputValidators.executeValidators(args))
      System.out.println("Error while verifying the input data");
  }
}
