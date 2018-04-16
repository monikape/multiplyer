package com.sda.client;

import com.sda.server.ReadBuff;
import com.sda.server.WriteBuff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {


    public static void main(String[] args) throws IOException {

        //host serwera
        String host = "localhost";
        //port serwera
        int port = 4444;

        //Tworzymy gniazdo do polaczenia z serwerem
        Socket socket = new Socket(host,port);

        ReadBuff readBuff = new ReadBuff(socket);
        WriteBuff writeBuff = new WriteBuff(socket);
        Thread threadR = new Thread(readBuff);
        Thread threadW = new Thread(writeBuff);
        threadR.start();
        threadW.start();

     /*   //BufferedReader odczyt z serwera
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //PrintWriter - wysylanie do serwera
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

        //Wyslij do serwera
        printWriter.println("Hello from client!.......ELLO");
        //Wypchnij z bufora
        printWriter.flush();

        //Odczytaj od serwera
        String response = reader.readLine();
        System.out.println("Response: "+response);
        //Zamknij strumienie
        printWriter.close();
        reader.close();*/


    }
}
