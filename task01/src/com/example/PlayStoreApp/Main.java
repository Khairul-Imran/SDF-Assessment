package com.example.PlayStoreApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

  public static final int COL_CATEGORY = 1;
  public static final int COL_APP_NAME = 0;
  public static final int COL_RATING = 2;

  public static final String[] LABELS = {
    //
  };

  public static void main(String[] args) {
    
    // To change to args[0] later.
    try (FileReader fr = new FileReader("googleplaystore.csv")) {
      BufferedReader br = new BufferedReader(fr);
      
      // This array or list is to get all the categories.


      // Need something to keep track of the COUNT and DISCARDED.

      

      // This map is for the final output.
      Map<String, List<PlaystoreData>> categorised = br.lines()
        .skip()




    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}