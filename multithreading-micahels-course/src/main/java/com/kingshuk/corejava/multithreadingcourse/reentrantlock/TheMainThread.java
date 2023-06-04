package com.kingshuk.corejava.multithreadingcourse.reentrantlock;

public class TheMainThread {

    public static void main(String[] args) {
        AmazonInventory inventory = new AmazonInventory();
        new Thread(new InventoryUpdater(inventory)).start();
        new Thread(new AmazonUI(inventory)).start();
        new Thread(new ProductPurchaser(inventory)).start();
    }
}
