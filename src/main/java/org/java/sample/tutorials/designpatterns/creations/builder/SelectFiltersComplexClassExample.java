package org.java.sample.tutorials.designpatterns.creations.builder;

import java.util.Map;

/**
 * SelectFiltersComplexClassExample class is a placeholder for storing information about UI
 * based filter selection for fetching a set of results from backend.
 * <p>
 * Assuming this class is responsible for applying all the filters
 * based on the inputs provided to us. We need to generate a final object which would
 * hold the expected result of filters.
 */
public class SelectFiltersComplexClassExample {
  private static final int DEFAULT_LIMIT = 100;

  private String advertiserID;
  private String campaignID;
  private int limitFor;
  private String startDate;
  private String endDate;
  private boolean excludeInActiveData;
  private Map<String, Integer> filterCriteria;

  public SelectFiltersComplexClassExample() {
  }

  public SelectFiltersComplexClassExample(String advertiserID, String campaignID, int limitFor,
      String startDate, String endDate, boolean excludeInActiveData,
      Map<String, Integer> filterCriteria) {
    this.advertiserID = advertiserID;
    this.campaignID = campaignID;
    this.limitFor = limitFor;
    this.startDate = startDate;
    this.endDate = endDate;
    this.excludeInActiveData = excludeInActiveData;
    this.filterCriteria = filterCriteria;
  }

  public SelectFiltersComplexClassExample(String advertiserID, String campaignID, int limitFor,
      String startDate, String endDate) {
    this(advertiserID, campaignID, limitFor, startDate, endDate, false, null);
  }

  public SelectFiltersComplexClassExample(String advertiserID, String campaignID, String startDate,
      String endDate) {
    this(advertiserID, campaignID, DEFAULT_LIMIT, startDate, endDate, false, null);
  }

  public String getAdvertiserID() {
    return advertiserID;
  }

  public void setAdvertiserID(String advertiserID) {
    this.advertiserID = advertiserID;
  }

  public String getCampaignID() {
    return campaignID;
  }

  public void setCampaignID(String campaignID) {
    this.campaignID = campaignID;
  }

  public int getLimitFor() {
    return limitFor;
  }

  public void setLimitFor(int limitFor) {
    this.limitFor = limitFor;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public boolean isExcludeInActiveData() {
    return excludeInActiveData;
  }

  public void setExcludeInActiveData(boolean excludeInActiveData) {
    this.excludeInActiveData = excludeInActiveData;
  }

  public Map<String, Integer> getFilterCriteria() {
    return filterCriteria;
  }

  public void setFilterCriteria(Map<String, Integer> filterCriteria) {
    this.filterCriteria = filterCriteria;
  }
}
