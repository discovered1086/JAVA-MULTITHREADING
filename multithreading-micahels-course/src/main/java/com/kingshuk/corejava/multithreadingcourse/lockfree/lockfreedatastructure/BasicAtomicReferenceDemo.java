package com.kingshuk.corejava.multithreadingcourse.lockfree.lockfreedatastructure;

import java.util.concurrent.atomic.AtomicReference;

public class BasicAtomicReferenceDemo {

    public static void main(String[] args) {
        String oldAddress = "675 Woodlands Pkwy";
        String newAddress = "233 E Wacker Dr.";

        AtomicReference<String> reference = new AtomicReference<>(oldAddress);
        reference.set("4 Villa Verde Dr.");
        if (reference.compareAndSet(oldAddress, newAddress)) {
            System.out.println("New address is: " + reference.get());
        } else {
            System.out.println("Nothing changed");
        }
    }
}
