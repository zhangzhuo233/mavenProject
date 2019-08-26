package com.bd.socketTest;


import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: javacore
 * @description: Client
 * @author: Mr.zhang
 * @create: 2019-08-26 17:21
 **/
public class ClientTalk {
    public static void main(String[] args) throws IOException {
        System.out.println("Client start...");
        Socket clientSocket = new Socket("localhost", 7070);
        OutputStream outputStream = clientSocket.getOutputStream();
        outputStream.write("在吗，猪?".getBytes());
        outputStream.close();
        clientSocket.close();
    }
}
