package com.kingshuk.corejava.multithreadingcourse.advancedlocking.reentrantreadwritelock.regularlock;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class InventoryUpdater implements Runnable {
    @NonNull
    private AmazonInventoryRegularLock amazonInventoryReadWriteLock;
    private final Random random = new Random();

    @Override
    public void run() {
        while (true) {
            //This is to simulate a network call or some delay
            // in getting the product details

            amazonInventoryReadWriteLock.addProductQuantity("Toothbrush", random.nextInt(15000));

            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
            }
        }
    }
}

