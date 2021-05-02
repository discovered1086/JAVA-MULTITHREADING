package com.kingshuk.corejava.multithreadingcourse.threadcoordination.threadjoin;

import org.javatuples.Pair;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static com.kingshuk.corejava.multithreadingcourse.threadcoordination.threadjoin.ThreadJoinDemo.processCalculatorThreads;

public class ThreadJoinTimeoutDemo {
    public static void main(String[] args) throws InterruptedException {
        List<Pair<BigInteger, BigInteger>> numbers =
                Arrays.asList(Pair.with(BigInteger.valueOf(589), BigInteger.valueOf(24)),
                        Pair.with(BigInteger.valueOf(458), BigInteger.valueOf(58)),
                        Pair.with(BigInteger.valueOf(789744785), BigInteger.valueOf(654564564)),
                        Pair.with(BigInteger.valueOf(21), BigInteger.valueOf(85)));


        processCalculatorThreads(numbers, 5000, true, true);
    }
}
