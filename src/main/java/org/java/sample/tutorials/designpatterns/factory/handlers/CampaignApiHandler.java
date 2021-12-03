package org.java.sample.tutorials.designpatterns.factory.handlers;

import org.java.sample.tutorials.designpatterns.factory.validators.CampaignValidator;

public class CampaignApiHandler implements ApiHandler {

  private final CampaignValidator campaignValidator;

  public CampaignApiHandler(CampaignValidator campaignValidator) {
    this.campaignValidator = campaignValidator;
  }

  @Override
  public void handleRequest(String requestBody) {

  }
}
