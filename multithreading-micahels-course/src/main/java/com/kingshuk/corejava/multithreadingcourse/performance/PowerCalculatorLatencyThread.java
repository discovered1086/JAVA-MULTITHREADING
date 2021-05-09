package com.kingshuk.corejava.multithreadingcourse.performance;

import lombok.Getter;
import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.List;

@Getter
public class PowerCalculatorLatencyThread extends Thread {
    private final List<Pair<BigInteger, BigInteger>> numbers;
    private boolean finished = false;
    private BigInteger result = BigInteger.ONE;
    private BigInteger sum = BigInteger.ZERO;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public PowerCalculatorLatencyThread(List<Pair<BigInteger, BigInteger>> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (Pair<BigInteger, BigInteger> numberPair : this.numbers) {
            for (BigInteger i = BigInteger.ZERO; i.compareTo(numberPair.getValue1()) != 0; i = i.add(BigInteger.ONE)) {
                if (this.isInterrupted()) {
                    logger.info("Thread has been interrupted");
                    result = BigInteger.ZERO;
                    break;
                }
                result = result.multiply(numberPair.getValue0());
            }

            sum = sum.add(result);
        }

        if (!this.isInterrupted()) {
            finished = true;
        }

    }
}
