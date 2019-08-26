package com.bd.socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: javacore
 * @description: 多线程实现
 * @author: Mr.zhang
 * @create: 2019-08-26 23:19
 **/
public class ServerByMultiThread {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientAccept = null;
        try {
            serverSocket = new ServerSocket(5050);
            System.out.println("服务已启动...");
            while (true) {
                clientAccept = serverSocket.accept();
                new Thread(new MyTask(clientAccept)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
class MyTask implements Runnable {
    private Socket clientAccept = null;
    public MyTask(Socket clientAccept) {
        this.clientAccept = clientAccept;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(clientAccept.getInputStream()));
            System.out.println("收到来自" + clientAccept.getInetAddress()
                    + "的消息:" + bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
