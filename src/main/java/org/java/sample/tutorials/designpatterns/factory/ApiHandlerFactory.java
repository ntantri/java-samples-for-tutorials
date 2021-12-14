package org.java.sample.tutorials.designpatterns.factory;

import org.java.sample.tutorials.designpatterns.factory.handlers.AdvertiserApiHandler;
import org.java.sample.tutorials.designpatterns.factory.handlers.ApiHandler;
import org.java.sample.tutorials.designpatterns.factory.handlers.CampaignApiHandler;
import org.java.sample.tutorials.designpatterns.factory.validators.AdvertiserValidator;
import org.java.sample.tutorials.designpatterns.factory.validators.CampaignValidator;

public class ApiHandlerFactory {
  public static ApiHandler getApiHandler(String apiType) {
    if (apiType.equals("Advertiser")) {
      AdvertiserValidator advertiserValidator = new AdvertiserValidator();
      return new AdvertiserApiHandler(advertiserValidator);
    } else {
      CampaignValidator campaignValidator = new CampaignValidator();
      return new CampaignApiHandler(campaignValidator);
    }
  }
}
