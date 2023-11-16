package com.example.NetworkingChallenge;

import java.net.Socket;

public class Client {

  public static final Integer DEFAULT_PORT = 3000;
  public static final String DEFAULT_SERVER = "Localhost";

  public static void main(String[] args) throws Exception{
    // If no parameters given.
    int port = DEFAULT_PORT; 
    String server = DEFAULT_SERVER;

    if (args.length == 1) { // If 1 parameter given.
      port = Integer.parseInt(args[0]);
    } else if (args.length == 2) { // If 2 parameters given.
      server = args[0];
      port = Integer.parseInt(args[1]);
    }

    Socket socket = new Socket(server, port);
    ClientSessionManager session = new ClientSessionManager(socket);

    session.start();
  }
}