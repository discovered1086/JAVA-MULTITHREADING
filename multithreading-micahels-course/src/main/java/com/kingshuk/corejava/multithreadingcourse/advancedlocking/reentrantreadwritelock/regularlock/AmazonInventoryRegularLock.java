package com.kingshuk.corejava.multithreadingcourse.advancedlocking.reentrantreadwritelock.regularlock;

import com.kingshuk.corejava.multithreadingcourse.advancedlocking.Product;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;


@Data
public class AmazonInventoryRegularLock {
    private ReentrantLock productLock = new ReentrantLock();
    private Map<String, Product> inventory = new HashMap<>();

    public AmazonInventoryRegularLock() {
        inventory.put("Toothbrush", Product.builder()
                .productPrice(25.6)
                .productName("Toothbrush")
                .quantityLeft(1)
                .build());
        inventory.put("Chinese Wok", Product.builder()
                .productPrice(100.5)
                .productName("Chinese Wok")
                .quantityLeft(1)
                .build());
        inventory.put("Carpet Cleaner", Product.builder()
                .productPrice(150)
                .quantityLeft(1)
                .productName("Carpet Cleaner")
                .build());
        inventory.put("CounterTop filter", Product.builder()
                .productPrice(400.80)
                .productName("CounterTop filter")
                .quantityLeft(1)
                .build());
        inventory.put("Mountain Bike", Product.builder()
                .productPrice(800)
                .productName("Mountain Bike")
                .quantityLeft(1)
                .build());
    }

    public void addProductQuantity(String productName, int quantity) {
        productLock.lock();
        try {
            if (inventory.containsKey(productName)) {
                Product product = inventory.get(productName);
                product.setQuantityLeft(product.getQuantityLeft() + quantity);
                inventory.put(productName, product);
            } else {
                System.out.println("We don't sell this product");
            }
        } finally {
            productLock.unlock();
        }
    }

    public Map<String, Product> getInventory() {
        productLock.lock();
        try {
            return inventory;
        } finally {
            productLock.unlock();
        }
    }
}
