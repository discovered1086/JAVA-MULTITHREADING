package com.kingshuk.corejava.multithreadingcourse.advancedlocking.reentrantlock;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@SuppressWarnings("java:S125")
public class AmazonUI implements Runnable {
    @NonNull
    private AmazonInventory amazonInventory;

    @Override
    public void run() {
        while (true) {
            if (amazonInventory.getProductLock().tryLock()) {
                try {
                    System.out.println("============Viewing user: " + Thread.currentThread().getName() + "============Inventory at: " +
                            LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "==========================");
                    amazonInventory.getInventory().keySet().forEach(key -> System.out.println("Item: " + key + ", Available quantity: " +
                            amazonInventory.getInventory().get(key).getQuantityLeft() + "\n"));
                    System.out.println("============================================================================");
                } finally {
                    amazonInventory.getProductLock().unlock();
                }
            }

            // ----------------------------------------------
            /*If we didn't use tryLock
            amazonInventory.getProductLock().lock();
            try {
                System.out.println("========================Inventory at: " +
                        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "==========================");
                amazonInventory.getInventory().keySet().forEach(key -> {
                    System.out.println("Item: " + key + ", Available quantity: " +
                            amazonInventory.getInventory().get(key).getQuantityLeft() + "\n");
                });
                System.out.println("============================================================================");
            } finally {
                amazonInventory.getProductLock().unlock();
            }
            */
            // ----------------------------------------------

        }

    }
}
