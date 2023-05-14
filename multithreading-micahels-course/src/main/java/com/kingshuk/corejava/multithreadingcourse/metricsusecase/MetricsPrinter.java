package com.kingshuk.corejava.multithreadingcourse.metricsusecase;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MetricsPrinter extends Thread {
    private MetricsCalculator metricsCalculator;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            double average = metricsCalculator.getAverageTimeTaken();

            System.out.println("The average time taken is: " + average);
        }
    }
}
