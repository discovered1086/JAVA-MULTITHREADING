package com.kingshuk.corejava.multithreadingcourse;

public class FirstMultiThreadingDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() ->
                System.out.println("This is a new thread: "+ Thread.currentThread().getName()+ (100/0)));

        thread.setName("Worker thread");

        thread.setUncaughtExceptionHandler((t, e) ->
                System.out.println("a critical error has occurred in thread: "+t.getName()+" , " + e));

        System.out.println("Before starting the new thread, in the thread: "+ Thread.currentThread().getName());
        thread.start();

        System.out.println("After starting the new thread, in the thread: "+ Thread.currentThread().getName());
    }
}
