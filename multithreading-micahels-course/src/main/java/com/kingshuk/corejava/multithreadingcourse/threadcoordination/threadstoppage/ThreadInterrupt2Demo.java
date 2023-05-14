package com.kingshuk.corejava.multithreadingcourse.threadcoordination.threadstoppage;

import com.kingshuk.corejava.multithreadingcourse.threadcoordination.PowerCalculatorThread;

import java.math.BigInteger;

public class ThreadInterrupt2Demo {

    public static void main(String[] args) {
        Thread thread = new PowerCalculatorThread(new BigInteger("2000000"),
                new BigInteger("1000000"));

        thread.start();

        System.out.println("Done from the main thread");

        thread.interrupt();
    }
}
