package com.example.NetworkingChallenge;

public class Product {
  Integer productId;
  Double price;
  Integer rating;

  public Product(Integer productId, Double price, Integer rating) {
    this.productId = productId;
    this.price = price;
    this.rating = rating;    
  }

  public Integer getProductId() {
    return productId;
  }

  public Integer getRating() {
    return rating;
  }

  public Double getPrice() {
    return price;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }
}
