package org.java.sample.tutorials.designpatterns.factory;

import org.java.sample.tutorials.designpatterns.factory.handlers.ApiHandler;

public class RequestExecutionerFactoryExample {

  public void handleApiRequests(String apiType, String requestBody) {
    ApiHandler apiHandler = ApiHandlerFactory.getApiHandler(apiType);
    apiHandler.handleRequest(requestBody);
  }
}
