package com.sda.server;

import com.sda.encryption.CaesarCipher;
import com.sda.encryption.Cipher;

import java.io.*;
import java.net.Socket;

public class ReadBuff implements Runnable {

    private Socket clientSocket;
    private Cipher cipher;

    public ReadBuff(Socket clientSocket) {
        this.clientSocket = clientSocket;
        cipher = new CaesarCipher(3);
    }

    @Override
    public void run() {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String next;
            while ((next = bufferedReader.readLine()) != null) {
                String decrypt = cipher.decrypt(next);
                System.out.println(next);
                System.out.println(decrypt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
