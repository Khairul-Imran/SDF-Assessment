package com.example.PlayStoreApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

  public static final int COL_CATEGORY = 1;
  public static final int COL_APP_NAME = 0;
  public static final int COL_RATING = 2;

  public static final String[] LABELS = {
    //
  };

  public static void main(String[] args) {
    
    try (FileReader fr = new FileReader(args[0])) {
      BufferedReader br = new BufferedReader(fr);
      


      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}