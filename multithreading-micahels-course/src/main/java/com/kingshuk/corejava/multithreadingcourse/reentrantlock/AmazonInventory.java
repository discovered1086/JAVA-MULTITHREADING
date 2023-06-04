package com.kingshuk.corejava.multithreadingcourse.reentrantlock;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


@Data
public class AmazonInventory {
    private Lock productLock = new ReentrantLock();
    private Map<String, Product> inventory = new HashMap<>();

    public AmazonInventory() {
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
        if (inventory.containsKey(productName)) {
            Product product = inventory.get(productName);
            product.setQuantityLeft(product.getQuantityLeft() + quantity);
            inventory.put(productName, product);
        } else {
            System.out.println("We don't sell this product");
        }
    }

    public void productPurchased(String productName, int quantity) {
        Product product = inventory.get(productName);
        product.setQuantityLeft(product.getQuantityLeft() - quantity);
        inventory.put(productName, product);
    }

}
