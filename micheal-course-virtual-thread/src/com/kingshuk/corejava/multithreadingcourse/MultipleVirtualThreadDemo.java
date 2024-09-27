package com.kingshuk.corejava.multithreadingcourse;

import java.util.ArrayList;
import java.util.List;

public class MultipleVirtualThreadDemo {
    private static final int NUMBER_OF_VIRTUAL_THREADS = 1000;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> System.out.println("Current thread: " + Thread.currentThread());
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
