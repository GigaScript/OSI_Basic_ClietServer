package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8080;
        try (
                Socket clientSocket = new Socket(host, port);
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {


            {
                out.println("Sergey");
                String resp = in.readLine();
                System.out.println(resp);
                System.out.println(in.readLine());
                out.println(SCANNER.nextLine());
                System.out.println(in.readLine());
                out.println(SCANNER.nextLine());
                System.out.println(in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}