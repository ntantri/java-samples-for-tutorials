package org.java.sample.tutorials.designpatterns.strategy.validators;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilenameValidatorStrategy implements Validator {

  @Override
  public boolean validate(String[] request) {
    boolean complete = true;
    for (FilenameValidator filenameValidator : FilenameValidator.values()) {
      complete = complete && filenameValidator.validate(request[1]);
      if (!complete)
        return complete;
    }
    return complete;
  }

  enum FilenameValidator {
    FILE_NAME {
      @Override
      boolean validate(String filename) {
        if (filename.isBlank() || filename.isEmpty()) {
          System.out.println("Please provide a valid filename");
          return false;
        }
        return true;
      }
    },

    FILE_INVALID {
      @Override
      boolean validate(String filename) {
        Path filePath = Paths.get(filename);
        if (!Files.exists(filePath) || !Files.isDirectory(filePath)) {
          System.out.println(
              "Filename given is invalid, it either doesn't exist or is a directory");
          return false;
        }
        return true;
      }
    },

    FILE_CONTENT_TYPE {
      @Override
      boolean validate(String filename) {
        Path filePath = Paths.get(filename);
        try {
          if (!("text/csv".equals(Files.probeContentType(filePath)))) {
            System.out.println("File is not a CSV");
            return false;
          }
        } catch (IOException e) {
          System.out.println("File is not a CSV");
          return false;
        }
        return true;
      }
    };

    abstract boolean validate(String filePath);
  }
}
