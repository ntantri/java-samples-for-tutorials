package org.java.sample.tutorials.designpatterns.factory.handlers;

import org.java.sample.tutorials.designpatterns.factory.validators.AdvertiserValidator;

public class AdvertiserApiHandler implements ApiHandler {
  private final AdvertiserValidator advertiserValidator;

  public AdvertiserApiHandler(AdvertiserValidator advertiserValidator) {
    this.advertiserValidator = advertiserValidator;
  }

  @Override
  public void handleRequest(String requestBody) {

  }
}
