package com.example.NetworkingChallenge;

public class Product {
  Integer productId;
  Integer rating;
  Integer price;

  public Product(Integer productId, Integer rating, Integer price) {
    this.productId = productId;
    this.rating = rating;
    this.price = price;
  }

  public Integer getProductId() {
    return productId;
  }

  public Integer getRating() {
    return rating;
  }

  public Integer getPrice() {
    return price;
  }
}
