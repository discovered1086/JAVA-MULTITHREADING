package com.kingshuk.corejava.multithreadingcourse.threadcoordination.threadstoppage;

import lombok.AllArgsConstructor;

import java.math.BigInteger;

public class DaemonThreadDemo {

    public static void main(String[] args) {
        Thread thread = new BlockingThread(new BigInteger("2000000"), new BigInteger("1000000"));

        thread.setDaemon(true);
        thread.start();

        System.out.println("Done from the main thread");

        thread.interrupt();
    }

    @AllArgsConstructor
    private static class BlockingThread extends Thread {
        private final BigInteger base;
        private final BigInteger power;

        @Override
        public void run() {
            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(this.power) != 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(this.base);
            }

            System.out.println(result);

        }
    }
}
