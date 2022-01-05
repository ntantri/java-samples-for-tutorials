package org.java.sample.tutorials.designpatterns.strategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.java.sample.tutorials.designpatterns.strategy.validators.InputValidators;

public class ValidateCookieDataNonStrategy {

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Please provide valid args for processing browser cookies");
      System.exit(1);
    }

    String dateStr = args[1];  // Date Validation Strategy
    String filename = args[2]; // Filename Validation Strategy

    validateDateAndExitOnError(dateStr);
    validateFileName(filename);
  }

  private static void validateDateAndExitOnError(String dateStr) {
    if (dateStr.isBlank() || dateStr.isEmpty()) {
      System.out.println("Please provide a valid date");
      System.exit(1);
    }

    try {
      LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    } catch (DateTimeParseException dateTimeParseEx) {
      System.out.println("Please provide a valid date format, like yyyy-MM-dd");
      System.exit(1);
    }

    try {
      LocalDate givenDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      if (givenDate.isAfter(LocalDate.now())) {
        System.out.println("Date provided is wrong, the date can't be in future");
        System.exit(1);
      }
    } catch (DateTimeParseException dateTimeParseEx) {
      System.out.println("Please provide a valid date format, like yyyy-MM-dd");
      System.exit(1);
    }
  }

  private static void validateFileName(String filename) {
    if (filename.isBlank() || filename.isEmpty()) {
      System.out.println("Please provide a valid filename");
      System.exit(1);
    }

    Path filePath = Paths.get(filename);
    if (!Files.exists(filePath) || !Files.isDirectory(filePath)) {
      System.out.println("Filename given is invalid, it either doesn't exist or is a directory");
      System.exit(1);
    }

    try {
      if (!("text/csv".equals(Files.probeContentType(filePath)))) {
        System.out.println("File is not a CSV");
        System.exit(1);
      }
    } catch (IOException e) {
      System.out.println("File is not a CSV");
      System.exit(1);
    }
  }
}
