package com.sda.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Proxy implements Runnable{
    private Socket clientSocket;
    private ReadBuff readBuff;
    private WriteBuff writeBuff;

    public Proxy(ReadBuff readBuff, WriteBuff writeBuff) {
        this.readBuff = readBuff;
        this.writeBuff = writeBuff;
    }


    @Override
    public void run() {

    }
}
