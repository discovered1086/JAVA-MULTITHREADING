package com.kingshuk.corejava.multithreadingcourse.concurrencyproblems.deadlockrailroad;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@SuppressWarnings({"java:S106", "java:S2189"})
public class RailRoadDeadLockDemo {

    @RequiredArgsConstructor
    public static class TrainA implements Runnable {
        @NonNull
        private RailRoadSystem railRoadSystem;
        //This is to create a random train schedule
        private final Random random = new Random();

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(random.nextInt(5));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                railRoadSystem.useTrackA();
            }

        }
    }

    @RequiredArgsConstructor
    public static class TrainB implements Runnable {
        @NonNull
        private RailRoadSystem railRoadSystem;

        //This is to create a random train schedule
        private final Random random = new Random();

        @Override
        public void run() {
            while (true) {
                //This is to simulate the scenario that it takes
                //1-10 milliseconds for the train to reach the intersection
                try {
                    Thread.sleep(random.nextInt(5));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                railRoadSystem.useTrackB();
            }
        }
    }

    public static void main(String[] args) {
        RailRoadSystem system = new RailRoadSystem();

        Thread trainAThread = new Thread(new TrainA(system), "TrainA");
        Thread trainBThread = new Thread(new TrainB(system), "TrainB");

        trainAThread.start();
        trainBThread.start();
    }

}
