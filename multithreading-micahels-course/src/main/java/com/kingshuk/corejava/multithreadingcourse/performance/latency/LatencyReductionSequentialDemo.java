package com.kingshuk.corejava.multithreadingcourse.performance.latency;

import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.List;

public class LatencyReductionSequentialDemo {
    private static final Logger logger = LoggerFactory.getLogger(LatencyReductionSequentialDemo.class);

    public static void main(String[] args) throws InterruptedException {
//        List<Pair<BigInteger, BigInteger>> numbers = NumberProvider.produceListWithFourNumbers();

        List<Pair<BigInteger, BigInteger>> numbers = NumberProvider.produceListWithFourteenNumbers();

        PowerCalculatorLatencyThread latencyThread = new PowerCalculatorLatencyThread(numbers);

        final long startTime = System.currentTimeMillis();
        latencyThread.start();
        latencyThread.join();

        if (latencyThread.isFinished()) {
            logger.info("The result has been calculated");
        } else {
            logger.info("The thread {} is still working on the calculation", latencyThread.getName());
        }
        final long endTime = System.currentTimeMillis();

        logger.info("Time taken by sequential calculation {} milliseconds", (endTime - startTime));
    }
}
