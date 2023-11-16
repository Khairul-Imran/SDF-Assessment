package com.example.NetworkingChallenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClientSessionManager {

  private final Socket socket;

  public ClientSessionManager(Socket socket) {
    this.socket = socket;
  }

  public void start() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

    final Console console = System.console();
    boolean stop = false;

    while (!stop) {
      String line = console.readLine(">Enter to receive data from the server.");
      line = line.trim() + "\n";

      bw.write(line);
      bw.flush();

      List<Product> productDetails = new ArrayList<>();
      int counter = 0; // For counting processed products.
      String RequestID;
      Integer itemCount = 0;
      Double budget = 0d;
      Product product = new Product(itemCount, budget, itemCount);

      while (true) { // Gets the data from the Server.
        String result = br.readLine();
        result = result.trim();

        // Assigns the properties to the product object or to the necessary variables.
        if (result.startsWith("request_id: ")) {
          RequestID = result.substring(11);
        } else if (result.startsWith("item_count: ")) {
          itemCount = Integer.parseInt(result.substring(11));
        } else if (result.startsWith("budget: ")) {
          budget = Double.parseDouble(result.substring(7));
        } else if ("prod_start".equals(result)) {
          product = new Product(itemCount, budget, itemCount);
        } else if (result.startsWith("prod_id: ")) {
          int id = Integer.parseInt(result.substring(9));
          product.setProductId(id);
        } else if (result.startsWith("price: ")) {
          double price = Double.parseDouble(result.substring(6));
          product.setPrice(price);
        } else if (result.startsWith("rating: ")) {
          int rating = Integer.parseInt(result.substring(7));
          product.setRating(rating);
        } else if ("prod_end".equals(result)) {
          productDetails.add(product);
          counter++;
        } else {
          continue;
        }
        // Just to see the output.
        System.out.printf(">%s\n", result);
        
        // Sorting our list of products. Something is wrong here.....
        // productDetails.sort(Comparator.comparing(item -> item::getRating).thenComparing(product -> product::getPrice)).reversed();

      }
    }
    bw.flush();
    br.close();
    socket.close();
  }
}
