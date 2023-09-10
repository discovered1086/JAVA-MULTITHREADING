package com.kingshuk.corejava.multithreadingcourse.advancedlocking.reentrantreadwritelock.regularlock;

import com.kingshuk.corejava.multithreadingcourse.advancedlocking.Product;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RequiredArgsConstructor
@SuppressWarnings({"java:S125", "java:S106", "java:S1854", "java:S1481"})
public class AmazonUI implements Runnable {
    @NonNull
    private AmazonInventoryRegularLock amazonInventoryReadWriteLock;

    @Override
    public void run() {
        for (int i = 0; i < 200000; i++) {
            System.out.println("============Viewing user: " + Thread.currentThread().getName() + "============Inventory at: " +
                    LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "==========================");
//        amazonInventoryReadWriteLock.getInventory().keySet().forEach(key -> System.out.println("Item: " + key + ", Available quantity: " +
//                amazonInventoryReadWriteLock.getInventory().get(key).getQuantityLeft() + "\n"));
            Map<String, Product> inventory = amazonInventoryReadWriteLock.getInventory();
            System.out.println("============================================================================");
        }


    }

}

