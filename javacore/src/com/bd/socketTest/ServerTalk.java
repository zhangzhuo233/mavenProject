package com.bd.socketTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: javacore
 * @description: Server
 * @author: Mr.zhang
 * @create: 2019-08-26 17:21
 **/
public class ServerTalk {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7070);
        System.out.println("Server start...");
        Socket clientAccept = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(clientAccept.getInputStream()));
        System.out.println("客户端消息：" + in.readLine());
        in.close();
        serverSocket.close();
    }
}
