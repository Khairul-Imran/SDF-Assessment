package com.example.NetworkingChallenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    Double itemPrice = 0d;


    while (!stop) {
      String line = console.readLine(">Enter to receive data from the server.");
      line = line.trim() + "\n";

      bw.write(line);
      bw.flush();

      List<String> productDetails = new ArrayList<>();

      while ((line = br.readLine()) != "") { // Gets the data from the Server.
        String result = br.readLine();
        result = result.trim();
        if ("prod_end".equals(result)) { // Not necessary.
          break;
        }

        productDetails.add(result);
        System.out.printf(">%s\n", result);

        // Map<Integer, Map<Integer, Product>> output = result.stream()
        //   .sorted()



      }
      System.out.println("hello");
      System.out.println(Arrays.toString(productDetails.toArray()));

    }
    bw.flush();
    br.close();
    socket.close();
  }
  


}
