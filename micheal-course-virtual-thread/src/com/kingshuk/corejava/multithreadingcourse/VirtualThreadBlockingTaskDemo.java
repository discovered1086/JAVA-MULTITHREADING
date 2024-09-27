package com.kingshuk.corejava.multithreadingcourse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VirtualThreadBlockingTaskDemo {
    private static final int NUMBER_OF_VIRTUAL_THREADS = 100;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println("Inside thread: " + Thread.currentThread() + " BEFORE running the blocking task");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Inside thread: " + Thread.currentThread() + " AFTER running the blocking task");
        };

        List<Thread> virtualThreads = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_VIRTUAL_THREADS; i++) {
            virtualThreads.add(Thread.ofVirtual().unstarted(runnable));
        }

        for (Thread virtualThread : virtualThreads) {
            virtualThread.start();
        }

        for (Thread virtualThread : virtualThreads) {
            virtualThread.join();
        }
    }
}
