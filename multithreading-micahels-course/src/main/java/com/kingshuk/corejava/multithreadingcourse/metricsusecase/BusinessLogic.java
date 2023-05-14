package com.kingshuk.corejava.multithreadingcourse.metricsusecase;

import lombok.*;

import java.util.Random;

@RequiredArgsConstructor
@Getter
public class BusinessLogic extends Thread {
    @NonNull
    private MetricsCalculator metricsCalculator;
    private final Random random = new Random();

    @Override
    public void run() {
        while (true) {
            long start = System.currentTimeMillis();

            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            long end = System.currentTimeMillis();
            metricsCalculator.addSample(end - start);
        }

    }
}
