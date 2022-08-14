package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8080;
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                Socket clientSocket = serverSocket.accept(); // ждем подключения
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println("New connection accepted listen port " + clientSocket.getPort());
                final String name = in.readLine();
                out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                out.println("Write your name");
                String userName = in.readLine();
                out.println("Are you child? (yes/no)");
                String isChild = in.readLine();
                out.println(accessByRole(userName, isChild));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static String accessByRole(String userName, String isChild) {
        if (userName == null || userName.equals("")) {
            userName = "Unknown User";
        }

        if ((isChild.toLowerCase()).equals("no")) {
            return String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", userName);
        } else {
            return String.format("Welcome to the kids area, %s! Let's play!", userName);
        }
    }
}

