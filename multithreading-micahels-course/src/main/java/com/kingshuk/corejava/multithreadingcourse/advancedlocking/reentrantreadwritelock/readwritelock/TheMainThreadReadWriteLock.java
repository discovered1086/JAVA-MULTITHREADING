package com.kingshuk.corejava.multithreadingcourse.advancedlocking.reentrantreadwritelock.readwritelock;


import java.util.ArrayList;
import java.util.List;

public class TheMainThreadReadWriteLock {

    public static void main(String[] args) throws InterruptedException {
        AmazonInventoryReadWriteLock inventory = new AmazonInventoryReadWriteLock();
        Thread inventoryUpdaterThread = new Thread(new InventoryUpdaterReadWriteLock(inventory));
        inventoryUpdaterThread.setDaemon(true);
        inventoryUpdaterThread.start();

        List<Thread> userThreads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread reader = new Thread(new AmazonUIReadWriteLock(inventory), "reader-" + i);
            reader.setDaemon(true);
            userThreads.add(reader);
        }

        long startTime = System.currentTimeMillis();

        for (Thread userThread : userThreads) {
            userThread.start();
        }

        //Making each user to wait for other users to finish
        for (Thread userThread : userThreads) {
            userThread.join();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Total time taken: " + (endTime - startTime));

    }
}
