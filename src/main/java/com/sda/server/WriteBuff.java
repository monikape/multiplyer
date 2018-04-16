package com.sda.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriteBuff implements Runnable {


    private Socket clientSocket;


    public WriteBuff(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream())) {
            Scanner sc = new Scanner(System.in);

            while (clientSocket.isConnected()) {

                System.out.println("Podaj wiadomość: ");
                String nextLine = sc.nextLine();
                printWriter.println(nextLine);
                printWriter.flush();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
