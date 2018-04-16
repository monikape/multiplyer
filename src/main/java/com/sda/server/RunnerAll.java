package com.sda.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RunnerAll implements Runnable {

    long SLEEP_TIME = 5_000l;
    private Socket clientSocket;

    public RunnerAll(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        //Socket clientSocket = serverSocket.accept();
        //BufferedReader odczytuje to co wyslal klient
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //PrintWriter sluzy do wysylania wiadomosci do klienta
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Odczytaj linijke od klienta
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Received: " + line);
        //Uspij na 5 sek. Symulacja obliczen
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Odpowiedz do klienta
        printWriter.println("Response from server: " + line);
        //flush - wypchnij z bufora
        printWriter.flush();
        //Zamknij strumienie
        printWriter.close();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
