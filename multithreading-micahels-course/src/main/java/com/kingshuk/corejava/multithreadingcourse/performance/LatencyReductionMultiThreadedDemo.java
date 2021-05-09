package com.kingshuk.corejava.multithreadingcourse.performance;

import org.apache.commons.collections4.ListUtils;
import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class LatencyReductionMultiThreadedDemo {
    private static final Logger logger = LoggerFactory.getLogger(LatencyReductionMultiThreadedDemo.class);

    public static void main(String[] args) throws InterruptedException {
//        List<Pair<BigInteger, BigInteger>> numbers = NumberProvider.produceListWithFourNumbers();

        List<Pair<BigInteger, BigInteger>> numbers = NumberProvider.produceListWithFourNumbers();

        final List<List<Pair<BigInteger, BigInteger>>> partitions = ListUtils.partition(numbers, 2);

        final long startTime = System.currentTimeMillis();
        processCalculatorThreads(partitions);
        final long endTime = System.currentTimeMillis();

        logger.info("Time taken by multi-threaded calculation {} milliseconds", (endTime - startTime));
    }

    public static void processCalculatorThreads(List<List<Pair<BigInteger, BigInteger>>> partitions) throws InterruptedException {
        BigInteger sum = BigInteger.ZERO;
        final List<PowerCalculatorLatencyThread> calculatorThreads = partitions.stream()
                .map(PowerCalculatorLatencyThread::new)
                .collect(Collectors.toList());

        for (PowerCalculatorLatencyThread calculatorThread : calculatorThreads) {
            calculatorThread.start();
        }

        logger.info("Starting the calculation....");

        for (PowerCalculatorLatencyThread calculatorThread : calculatorThreads) {
            calculatorThread.join();
        }

        for (var i = 0; i < partitions.size(); i++) {
            final PowerCalculatorLatencyThread calculatorThread = calculatorThreads.get(i);
            if (calculatorThread.isFinished()) {
                sum = sum.add(calculatorThread.getSum());
                logger.info("The result has been calculated by {}", calculatorThread.getName());
            } else {
                logger.info("The thread {} is still working on the calculation", calculatorThread.getName());
            }
        }

        logger.info("Completed calculation...");
    }
}
