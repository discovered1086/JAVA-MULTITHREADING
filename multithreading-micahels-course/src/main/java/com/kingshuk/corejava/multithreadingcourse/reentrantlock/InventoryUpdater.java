package com.kingshuk.corejava.multithreadingcourse.reentrantlock;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class InventoryUpdater implements Runnable {
    @NonNull
    private AmazonInventory amazonInventory;
    private final Random random = new Random();

    @Override
    public void run() {
        while (true) {
            amazonInventory.getProductLock().lock();
            try {
                //This is to simulate a network call or some delay
                // in getting the product details
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                }
                amazonInventory.addProductQuantity("Toothbrush", random.nextInt(15000));
                amazonInventory.addProductQuantity("Chinese Wok", random.nextInt(100));
                amazonInventory.addProductQuantity("Carpet Cleaner", random.nextInt(150));
                amazonInventory.addProductQuantity("CounterTop filter", random.nextInt(200));
                amazonInventory.addProductQuantity("Mountain Bike", random.nextInt(400));
            } finally {
                amazonInventory.getProductLock().unlock();
            }
        }
    }
}
