package com.kingshuk.corejava.multithreadingcourse;

public class ExceptionHandlingInThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> System.out.println("This is a new thread: "+ Thread.currentThread().getName()));

        thread.setName("Worker thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Before starting the new thread, in the thread: "+ Thread.currentThread().getName());
        thread.start();

        System.out.println("After starting the new thread, in the thread: "+ Thread.currentThread().getName());

        Thread.sleep(10000);
    }
}
