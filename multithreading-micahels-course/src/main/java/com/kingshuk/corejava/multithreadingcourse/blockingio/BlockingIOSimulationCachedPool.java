package com.kingshuk.corejava.multithreadingcourse.blockingio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class BlockingIOSimulationCachedPool {
    private static final int NUMBER_OF_REQUESTS = 500000;

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
        List<Future<?>> futures = new ArrayList<>();

        ExecutorService service = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < NUMBER_OF_REQUESTS; i++) {
                futures.add(service.submit(BlockingIOSimulationCachedPool::blockingIOOperation));
            }

            for (Future<?> future : futures) {
                try {
                    future.get();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        } finally {
            service.shutdown();
        }
    }

    private static void blockingIOOperation() {
        System.out.println("Thread executing the current request: " + Thread.currentThread());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
