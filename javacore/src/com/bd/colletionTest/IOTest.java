package com.bd.colletionTest;

import java.io.*;

/**
 * @program: javacore
 * @description: 字节流测试
 * @author: Mr.zhang
 * @create: 2019-08-19 19:33
 **/
public class IOTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        int len = 0;
        byte[] bs = new byte[1024];
        try {
            fis = new FileInputStream("/Users/zhangzhuo/Desktop/jiake.png");
            fos = new FileOutputStream("/Users/zhangzhuo/Desktop/bak.png");

            while ((len = fis.read(bs, 0, bs.length)) != -1) {
                System.out.println(len);
                fos.write(bs, 0, len);
            }
            // Thread.sleep(10000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fis.close();
            fos.close();
        }
    }
}
