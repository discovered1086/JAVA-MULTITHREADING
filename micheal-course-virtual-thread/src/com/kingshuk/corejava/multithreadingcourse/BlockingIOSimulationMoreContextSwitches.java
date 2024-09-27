package com.kingshuk.corejava.multithreadingcourse;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BlockingIOSimulationMoreContextSwitches {
    private static final int NUMBER_OF_REQUESTS = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to start");
        scanner.nextLine();
        System.out.printf("Serving %d requests", NUMBER_OF_REQUESTS);

        long startTime = System.currentTimeMillis();
        processRequests();
        long endTime = System.currentTimeMillis();
        System.out.printf("Time taken to complete the request %dms %n", endTime - startTime);
    }

    private static void processRequests() {
        try(ExecutorService service = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < NUMBER_OF_REQUESTS; i++) {
                service.submit(() ->{
                    for(int j = 0; j < 100; j++){
                        blockingIOOperation();
                    }
                });
            }
        }
    }

    private static void blockingIOOperation() {
        System.out.println("Thread executing the current request: " + Thread.currentThread());
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
