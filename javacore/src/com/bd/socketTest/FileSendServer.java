package com.bd.socketTest;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @program: javacore
 * @description: recieve file server
 * @author: Mr.zhang
 * @create: 2019-08-26 19:27
 **/
public class FileSendServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        BufferedInputStream bufferedInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            serverSocket = new ServerSocket(5050);
            Socket clientAccept = serverSocket.accept();
            System.out.println("开始接受传输...");
            bufferedInputStream = new BufferedInputStream(clientAccept.getInputStream());
            fileOutputStream = new FileOutputStream("/Users/zhangzhuo/Downloads/software/bak.dmg");
            byte[] b = new byte[1024*4];
            int len = 0;
            while ((len = bufferedInputStream.read(b, 0, b.length)) != -1) {
                fileOutputStream.write(b, 0, len);
            }
            System.out.println("接受完毕!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream != null)
                    bufferedInputStream.close();
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
