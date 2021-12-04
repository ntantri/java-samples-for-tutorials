package org.java.sample.tutorials.designpatterns.builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class SelectFiltersBuilderExample {

  private final String advertiserID;
  private final String campaignID;
  private final int limitFor;
  private final String startDate;
  private final String endDate;
  private final boolean excludeInActiveData;
  private final Map<String, Integer> filterCriteria;

  private SelectFiltersBuilderExample(Builder builder) {
    this.advertiserID = builder.advertiserID;
    this.campaignID = builder.campaignID;
    this.limitFor = builder.limitFor;
    this.startDate = builder.startDate;
    this.endDate = builder.endDate;
    this.excludeInActiveData = builder.excludeInActiveData;
    this.filterCriteria = builder.filterCriteria;
  }

  public static class Builder {
    private static final int LIMIT = 100;

    private final String advertiserID;
    private final String campaignID;
    private int limitFor;
    private String startDate;
    private String endDate;
    private boolean excludeInActiveData;
    private Map<String, Integer> filterCriteria;

    public Builder(String advertiserId, String campaignId) {
      this.advertiserID = advertiserId;
      this.campaignID = campaignId;
      this.limitFor = LIMIT;
      this.startDate = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
      this.endDate = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    public Builder provideRange(String startDate, String endDate) {
      this.startDate = startDate;
      this.endDate = endDate;
      return this;
    }

    public Builder addLimit(int limitFor) {
      this.limitFor = limitFor;
      return this;
    }

    public Builder dontShowInactiveData() {
      this.excludeInActiveData = true;
      return this;
    }

    public Builder addFilters(Map<String, Integer> filterCriteria) {
      this.filterCriteria = filterCriteria;
      return this;
    }

    public SelectFiltersBuilderExample build() {
      return new SelectFiltersBuilderExample(this);
    }
  }
}
