package com.kingshuk.corejava.multithreadingcourse.reentrantlock;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class ProductPurchaser implements Runnable {
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
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                amazonInventory.productPurchased("Toothbrush", random.nextInt(500));
                amazonInventory.productPurchased("Chinese Wok", random.nextInt(50));
                amazonInventory.productPurchased("Carpet Cleaner", random.nextInt(25));
                amazonInventory.productPurchased("CounterTop filter", random.nextInt(125));
                amazonInventory.productPurchased("Mountain Bike", random.nextInt(90));
            } finally {
                amazonInventory.getProductLock().unlock();
            }
        }
    }
}
