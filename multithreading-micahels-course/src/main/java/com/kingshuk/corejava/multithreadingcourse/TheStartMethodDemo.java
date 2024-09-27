package com.kingshuk.corejava.multithreadingcourse;

public class TheStartMethodDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(() -> System.out.println("Hello from "+ Thread.currentThread().getName()));

        myThread.start();

        Thread.sleep(2000);
    }
}
