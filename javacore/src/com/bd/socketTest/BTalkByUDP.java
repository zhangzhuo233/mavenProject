package com.bd.socketTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @program: javacore
 * @description: 基于udp协议的网络编程，B点
 * @author: Mr.zhang
 * @create: 2019-08-27 17:49
 **/
public class BTalkByUDP {
    public static void main(String[] args) {
        DatagramSocket bSocket = null;
        try {
            bSocket = new DatagramSocket(5051);
            byte[] b = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(b, b.length);
            bSocket.receive(datagramPacket);
            System.out.println("B收到了来自A的消息:" + new String(datagramPacket.getData(), "utf-8"));

            byte[] replyMessage = "收到了思密达".getBytes();
            bSocket.send(new DatagramPacket(replyMessage, replyMessage.length,
                    InetAddress.getLocalHost(), 5050));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bSocket != null)
                bSocket.close();
        }

    }
}
