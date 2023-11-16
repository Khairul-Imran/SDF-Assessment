package com.example.PlayStoreApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

  public static final int COL_CATEGORY = 1;
  public static final int COL_APP_NAME = 0;
  public static final int COL_RATING = 2;

  public static final String[] LABELS = {
    //
  };

  public static void main(String[] args) {
    
    // To change to args[0] later.
    try (FileReader fr = new FileReader("task01/googleplaystore.csv")) {
      BufferedReader br = new BufferedReader(fr);
      
      // This array or list is to get all the categories.
      Map<String, List<PlaystoreAppData>> allCategories = br.lines()
        .skip(1)
        .map(row -> row.trim().split(","))
        .map(columns -> new PlaystoreAppData(columns[COL_APP_NAME], Float.parseFloat(columns[COL_RATING]), columns[COL_CATEGORY]))
        .collect(Collectors.groupingBy(app -> app.getCategory()));
        
      //System.out.println(Arrays.toString(allCategories.toArray()));
      //allCategories.forEach(System.out::println);

      for (String category : allCategories.keySet()) {
        List<PlaystoreAppData> appDatas = allCategories.get(category); 
        System.out.printf("%s (%d)\n", category, appDatas.size()); 
         for (PlaystoreAppData appData : appDatas) {
           System.out.printf("       \t%s, %d\n", appData.getAppName(), appData.getRating());
         }
       }


        //.anyMatch() -> might use this below instead.

      // Need something to keep track of the COUNT and DISCARDED.
      // TODO ask how to check for the different categories with upper and lowercase.



      // This map is for the final output.
      // Map<String, List<PlaystoreAppData>> categorised = br.lines()
      //   .skip()




    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}