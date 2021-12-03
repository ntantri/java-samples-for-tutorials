package org.java.sample.tutorials.designpatterns.factory;

import org.java.sample.tutorials.designpatterns.factory.handlers.AdvertiserApiHandler;
import org.java.sample.tutorials.designpatterns.factory.handlers.ApiHandler;
import org.java.sample.tutorials.designpatterns.factory.handlers.CampaignApiHandler;
import org.java.sample.tutorials.designpatterns.factory.validators.AdvertiserValidator;
import org.java.sample.tutorials.designpatterns.factory.validators.CampaignValidator;

public class RequestExecutionerNonFactoryExample {

  public void handleApiRequests(String apiType, String requestBody) {
    ApiHandler apiHandler;
    if (apiType.equals("Advertiser")) {
      AdvertiserValidator advertiserValidator = new AdvertiserValidator();
      apiHandler = new AdvertiserApiHandler(advertiserValidator);
    } else {
      CampaignValidator campaignValidator = new CampaignValidator();
      apiHandler = new CampaignApiHandler(campaignValidator);
    }
    apiHandler.handleRequest(requestBody);
  }
}
