package com.kingshuk.corejava.multithreadingcourse.threadcoordination;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

@Getter
public class PowerCalculatorThread extends Thread{
    private final BigInteger base;
    private final BigInteger power;
    private boolean finished = false;
    private BigInteger result= BigInteger.ONE;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public PowerCalculatorThread(BigInteger base, BigInteger power) {
        this.base = base;
        this.power = power;
    }

    @Override
    public void run() {
        for (BigInteger i = BigInteger.ZERO; i.compareTo(this.power) != 0; i = i.add(BigInteger.ONE)) {
            if (this.isInterrupted()) {
                logger.info("Thread has been interrupted");
                result = BigInteger.ZERO;
                break;
            }
            result = result.multiply(this.base);
        }

        if (!this.isInterrupted()) {
            finished= true;
        }

    }
}
