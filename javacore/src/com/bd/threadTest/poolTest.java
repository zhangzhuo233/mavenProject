package com.bd.threadTest;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: javacore
 * @description: ThreadPool Test
 * @author: Mr.zhang
 * @create: 2019-08-25 17:14
 **/
public class poolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }
        };
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);

        executorService.shutdown();
    }
}
