package com.example.PlayStoreApp;

public class PlaystoreAppData {

  private String appName;
  private double rating;
  private String category;

  public PlaystoreAppData(String appName, double rating, String category) {
    this.appName = appName;
    this.rating = rating;
    this.category = category;
  }




  // Getters and Setters
  public String getAppName() { return appName; }

  public void setAppName(String appName) { this.appName = appName; }

  public double getRating() { return rating; }

  public void setRating(Float rating) { this.rating = rating; }

  public String getCategory() { return category; }

  public void setCategory(String category) { this.category = category; }




  @Override
  public String toString() {
    return "PlaystoreAppData [appName=" + appName + ", rating=" + rating + ", category=" + category + "]";
  }

  


}
