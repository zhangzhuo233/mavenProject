package com.bd.threadTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: javacore
 * @description: Synchronized test
 * @author: Mr.zhang
 * @create: 2019-08-25 15:28
 **/
public class SynchronizedTest {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            int tickets = 100;
            Lock lock = new ReentrantLock();
            // public synchronized void sell() {
            //     // 同步判断条件
            //     if (tickets <= 0)
            //         return;
            //     try {
            //         Thread.sleep(100);
            //         System.out.println(Thread.currentThread().getName() + "  得到票  " + (tickets--));
            //     } catch (InterruptedException e) {
            //         e.printStackTrace();
            //     }
            // }
            public void sell() {
                lock.lock();
                // 同步判断条件
                if (tickets <= 0) {
                    lock.unlock();
                    return;
                }
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "  得到票  " + (tickets--));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

            @Override
            public void run() {
                while (true) {
                    // 减少进入synchronized方法的次数
                    if (tickets <= 0) {
                        break;
                    }
                    sell();
                }
            }
        };
        Thread t1 = new Thread(runnable);
        t1.setName("窗口1");
        t1.start();
        Thread t2 = new Thread(runnable);
        t2.setName("窗口2");
        t2.start();
    }
}
