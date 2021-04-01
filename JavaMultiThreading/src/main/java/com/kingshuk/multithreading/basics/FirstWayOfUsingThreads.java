package com.kingshuk.multithreading.basics;

import java.util.concurrent.TimeUnit;

public class FirstWayOfUsingThreads {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello again to multi-threading from runnable");
                try {
                    //Thread.sleep(900);
                    //Another way of making a thread sleep
                    TimeUnit.MICROSECONDS.sleep(900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Hello again to multi-threading from main");
            try {
                //Thread.sleep(1000);
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
