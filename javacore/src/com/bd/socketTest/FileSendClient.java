package com.bd.socketTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @program: javacore
 * @description: send file client
 * @author: Mr.zhang
 * @create: 2019-08-26 19:26
 **/
public class FileSendClient {
    public static void main(String[] args) {
        BufferedOutputStream outputStream = null;
        BufferedInputStream fileInputStream = null;
        Socket socket = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("192.168.0.101");
            socket = new Socket(inetAddress, 5050);
            outputStream = new BufferedOutputStream(socket.getOutputStream());
            fileInputStream = new BufferedInputStream(
                    new FileInputStream("/Users/zhangzhuo/Downloads/software/BaiduNetdisk_mac_2.2.3.dmg"));
            byte[] b = new byte[1024 * 4];
            int len = 0;
            System.out.println("开始传输...");
            while ((len = fileInputStream.read(b, 0, b.length)) != -1) {
                outputStream.write(b, 0, len);
            }
            System.out.println("传输完成!");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
