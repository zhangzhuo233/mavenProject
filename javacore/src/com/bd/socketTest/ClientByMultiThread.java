package com.bd.socketTest;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @program: javacore
 * @description: 多线程实现
 * @author: Mr.zhang
 * @create: 2019-08-26 23:18
 **/
public class ClientByMultiThread {
    public static void main(String[] args) {
        BufferedOutputStream outputStream = null;
        BufferedInputStream fileInputStream = null;
        Socket socket = null;
        try {
            while (true) {
                System.out.println("client输入消息:");
                Scanner sc = new Scanner(System.in);
                String message = sc.nextLine();
                if (message.equals("886"))
                    break;
                InetAddress inetAddress = InetAddress.getByName("192.168.0.101");
                socket = new Socket(inetAddress, 5050);
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()));
                bufferedWriter.write(message + '\n');
                bufferedWriter.flush();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("close socket!");
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
                if (outputStream != null)
                    outputStream.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
