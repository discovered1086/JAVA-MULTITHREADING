package com.kingshuk.corejava.multithreadingcourse.threadcoordination.threadjoin;

import com.kingshuk.corejava.multithreadingcourse.threadcoordination.PowerCalculatorThread;
import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreadJoinDemo {
    private static final Logger logger = LoggerFactory.getLogger(ThreadJoinDemo.class);

    public static void main(String[] args) {
        List<Pair<BigInteger, BigInteger>> numbers =
                Arrays.asList(Pair.with(BigInteger.valueOf(564584564), BigInteger.valueOf(564564564)),
                        Pair.with(BigInteger.valueOf(875125956), BigInteger.valueOf(58)),
                        Pair.with(BigInteger.valueOf(789744785), BigInteger.valueOf(654564564)),
                        Pair.with(BigInteger.valueOf(78545454), BigInteger.valueOf(8787)));


        final List<PowerCalculatorThread> calculatorThreads = numbers.stream()
                .map(pair -> new PowerCalculatorThread(pair.getValue0(), pair.getValue1()))
                .collect(Collectors.toList());

        calculatorThreads.forEach(Thread::start);

        logger.info("Starting the calculation....");
        for (int i = 0; i < numbers.size(); i++) {
            final PowerCalculatorThread calculatorThread = calculatorThreads.get(i);
            if (calculatorThread.isFinished()) {
                logger.info("The result of {}^{} is {}", calculatorThread.getBase(),
                        calculatorThread.getPower(), calculatorThread.getResult());
            } else {
                logger.info("The thread {} is still working on the calculation", calculatorThread.getName());
            }
        }

        logger.info("Completed calculation...");
    }
}
