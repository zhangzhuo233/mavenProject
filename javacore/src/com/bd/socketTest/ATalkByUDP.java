package com.bd.socketTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
 * @program: javacore
 * @description: 基于udp协议的网络编程，A点
 * @author: Mr.zhang
 * @create: 2019-08-27 17:47
 **/
public class ATalkByUDP {
    public static void main(String[] args) {
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket(5050);
            InetAddress addr = InetAddress.getLocalHost();
            byte[] message = "A点发送给B点的消息测试".getBytes("utf-8");
            aSocket.send(new DatagramPacket(message, 0, message.length, addr, 5051));
            DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);
            aSocket.receive(datagramPacket);
            System.out.println("A点来自B的消息收到的消息:" + new String(datagramPacket.getData(), "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (aSocket != null)
                aSocket.close();
        }
    }
}
