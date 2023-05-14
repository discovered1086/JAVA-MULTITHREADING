package com.kingshuk.corejava.multithreadingcourse.performance.latency;

import org.javatuples.Pair;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class NumberProvider {

    private NumberProvider(){
        throw new UnsupportedOperationException("This is not allowed");
    }

    public static List<Pair<BigInteger, BigInteger>> produceListWithFourNumbers(){
        return
                Arrays.asList(Pair.with(BigInteger.valueOf(5878989), BigInteger.valueOf(79877)),
                        Pair.with(BigInteger.valueOf(4588789), BigInteger.valueOf(5878)),
                        Pair.with(BigInteger.valueOf(8977785), BigInteger.valueOf(23878)),
                        Pair.with(BigInteger.valueOf(78578245), BigInteger.valueOf(8787)));
    }

    public static List<Pair<BigInteger, BigInteger>> produceListWithFourteenNumbers(){
        return
                Arrays.asList(Pair.with(BigInteger.valueOf(5878989), BigInteger.valueOf(79877)),
                        Pair.with(BigInteger.valueOf(4588789), BigInteger.valueOf(5878)),
                        Pair.with(BigInteger.valueOf(8977785), BigInteger.valueOf(23878)),
                        Pair.with(BigInteger.valueOf(78578245), BigInteger.valueOf(8787)),
                        Pair.with(BigInteger.valueOf(78578245), BigInteger.valueOf(8787)),
                        Pair.with(BigInteger.valueOf(78578245), BigInteger.valueOf(8787)),
                        Pair.with(BigInteger.valueOf(78578245), BigInteger.valueOf(8787)),
                        Pair.with(BigInteger.valueOf(78578245), BigInteger.valueOf(8787)),
                        Pair.with(BigInteger.valueOf(78578245), BigInteger.valueOf(8787)),
                        Pair.with(BigInteger.valueOf(78578245), BigInteger.valueOf(8787)),
                        Pair.with(BigInteger.valueOf(78578245), BigInteger.valueOf(8787)),
                        Pair.with(BigInteger.valueOf(78578245), BigInteger.valueOf(8787)),
                        Pair.with(BigInteger.valueOf(78578245), BigInteger.valueOf(8787)),
                        Pair.with(BigInteger.valueOf(78578245), BigInteger.valueOf(8787)));
    }
}
