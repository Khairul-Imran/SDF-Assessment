package com.example.PlayStoreApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {

  public static final int COL_CATEGORY = 1;
  public static final int COL_APP_NAME = 0;
  public static final int COL_RATING = 2;

  public static void main(String[] args) {

    if (args.length <= 0) {
      System.err.println("Please include the CSV file in your command.");
      System.exit(1);
    }
    
    System.out.printf("Processing %s\n", args[0]);
    // java -cp classes com.example.PlayStoreApp.Main googleplaystore.csv
    
    try (FileReader fr = new FileReader(args[0])) {
      BufferedReader br = new BufferedReader(fr);
      
      // Map<Category, List<PlaystoreAppData)
      Map<String, List<PlaystoreAppData>> allCategories = br.lines()
        .skip(1)
        .map(row -> row.trim().split(","))
        .map(columns -> new PlaystoreAppData(columns[COL_APP_NAME], Double.parseDouble(columns[COL_RATING]), columns[COL_CATEGORY]))
        .collect(Collectors.groupingBy(app -> app.getCategory()));
        
      // This loop prints everything - just for checking purposes. *****************
      // for (String category : allCategories.keySet()) {
      //   // appDatas represents the apps in each category.
      //   List<PlaystoreAppData> appDatas = allCategories.get(category);
      //   System.out.printf("Category: %s (%d)\n", category, appDatas.size());
      //   for (PlaystoreAppData appData : appDatas) {
      //     System.out.printf("       \t%s, %f\n", appData.getAppName(), appData.getRating());
      //   }
      // }

      System.out.println("This is the main loop printing the output you want.");
      for (String category : allCategories.keySet()) {
        // appDatas contains the apps in each category.
        List<PlaystoreAppData> appDatas = allCategories.get(category);

        // To track these for each category.
        String HighestApp = "";
        String LowestApp = "";
        Double HighestAppRating = 1d;
        Double LowestAppRating = 3d;
        Double categoryAverageRating = 0d;
        Double categoryTotalRating = 0d; // used to calculate average.
        int discardedRatings = 0;
        int countedRatings = 0;

        System.out.printf("Category: %s (%d)\n", category, appDatas.size());
        // Here looking at each app.
        for (PlaystoreAppData appData : appDatas) {
          if (appData.getRating() == (Double)appData.getRating() && appData.getRating() > HighestAppRating) { // Checking if a valid rating (not NaN) and if higher than current highest rating.
            HighestAppRating = appData.getRating();
            HighestApp = appData.getAppName();
            categoryTotalRating += appData.getRating();
            countedRatings++;
          } else if (appData.getRating() == (Double)appData.getRating() && appData.getRating() < LowestAppRating) { // Checking if a valid rating (not NaN) and if lower than current lowest rating.
            LowestAppRating = appData.getRating();
            LowestApp = appData.getAppName();
            categoryTotalRating += appData.getRating();
            countedRatings++;
          } else if (appData.getRating() == (Double)appData.getRating()) { // For those that are valid ratings, but are not the highest or lowest.
            categoryTotalRating += appData.getRating();
            countedRatings++;
          } else if (appData.getRating() != (Double)appData.getRating()) {
            discardedRatings++;
          }
          categoryAverageRating = categoryTotalRating / countedRatings;
        
        }
        System.out.printf("       \t Highest: %s, %f\n", HighestApp, HighestAppRating);
        System.out.printf("       \t Loweset: %s, %f\n", LowestApp, LowestAppRating);
        System.out.printf("       \t Average: %f\n", categoryAverageRating);
        System.out.printf("       \t Count: %d\n", countedRatings);
        System.out.printf("       \t Discarded: %d\n", discardedRatings);

      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}