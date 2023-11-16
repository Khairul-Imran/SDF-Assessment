package com.example.PlayStoreApp;

public class PlaystoreData {

  private String appName;
  private Float rating;
  private String category;

  public PlaystoreData(String appName, Float rating, String category) {
    this.appName = appName;
    this.rating = rating;
    this.category = category;
  }
  









  // Getters and Setters
  public String getAppName() { return appName; }

  public void setAppName(String appName) { this.appName = appName; }

  public Float getRating() { return rating; }

  public void setRating(Float rating) { this.rating = rating; }

  public String getCategory() { return category; }

  public void setCategory(String category) { this.category = category; }


}
