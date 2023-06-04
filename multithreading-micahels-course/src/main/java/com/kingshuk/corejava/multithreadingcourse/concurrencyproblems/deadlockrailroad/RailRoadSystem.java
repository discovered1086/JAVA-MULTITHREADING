package com.kingshuk.corejava.multithreadingcourse.concurrencyproblems.deadlockrailroad;

@SuppressWarnings("java:S106")
public class RailRoadSystem {
    private final Object trackA = new Object();
    private final Object trackB = new Object();

    public void useTrackA() {
        synchronized (trackA) {
            System.out.println("Train " + Thread.currentThread().getName() +" is passing through trackA");

            synchronized (trackB) {
                System.out.println("Track B is locked because train " + Thread.currentThread().getName() +
                        " is passing through track A");

                //This is to simulate the time it takes for a train to pass
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void useTrackB() {
        synchronized (trackA) {
            System.out.println("Train " + Thread.currentThread().getName() +" is passing through trackB");

            synchronized (trackB) {
                System.out.println("Track A is locked because train " + Thread.currentThread().getName() +
                        " is passing through track B");

                //This is to simulate the time it takes for a train to pass
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
