package com.sda.server;

import com.sda.encryption.CaesarCipher;
import com.sda.encryption.Cipher;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriteBuff implements Runnable {


    private Socket clientSocket;
    private Cipher cipher;


    public WriteBuff(Socket clientSocket) {
        this.clientSocket = clientSocket;
        cipher = new CaesarCipher(3);
    }

    @Override
    public void run() {
        try (PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream())) {
            Scanner sc = new Scanner(System.in);

            while (clientSocket.isConnected()) {

                System.out.println("Podaj wiadomość: ");
                String nextLine = sc.nextLine();
                String encrypt = cipher.encrypt(nextLine);
                printWriter.println(encrypt);
                printWriter.flush();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
