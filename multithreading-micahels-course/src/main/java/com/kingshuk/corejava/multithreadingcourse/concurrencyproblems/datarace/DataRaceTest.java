package com.kingshuk.corejava.multithreadingcourse.concurrencyproblems.datarace;

@SuppressWarnings("java:S106")
public class DataRaceTest {

    public static void main(String[] args) {
        //A single shared instance
        DataRaceSharedClass sharedClass = new DataRaceSharedClass();


        Thread t1 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sharedClass.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sharedClass.checkForDataRace();
            }
        });

        t1.start();
        t2.start();
    }

    public static class DataRaceSharedClass {
        private volatile int x = 0;
        private volatile int y = 0;

        public void increment() {
            x++;
            y++;
        }

        public void checkForDataRace() {
            if (y > x) {
                System.out.println("Data race detected, Y is greater than X");
            }
        }
    }
}
