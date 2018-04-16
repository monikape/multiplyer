package com.sda.server;

import java.io.*;
import java.net.Socket;

public class ReadBuff implements Runnable {

    private Socket clientSocket;

    public ReadBuff(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String next;
            while ((next = bufferedReader.readLine()) != null) {
                System.out.println(next);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
