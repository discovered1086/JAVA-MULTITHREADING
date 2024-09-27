package com.kingshuk.corejava.multithreadingcourse;

public class BasicVirtualThreadsDemo {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> System.out.println("Current thread: "+ Thread.currentThread());

//        Thread platformThread = Thread.ofPlatform().unstarted(runnable);
//
//        platformThread.start();
//        platformThread.join();

        Thread virtualThread = Thread.ofVirtual().unstarted(runnable);

        virtualThread.start();
        virtualThread.join();


    }
}
