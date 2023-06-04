package com.kingshuk.corejava.multithreadingcourse.concurrencyproblems.metricsusecase;

public class MetricsCalculator {
    private long sampleCount;
    private volatile double averageTimeTaken;

    public synchronized void  addSample(long sample){
        //There are 3 operations we need to perform
        //1. Calculate the current total
        double currentTotal = sampleCount * averageTimeTaken;

        //2. Then increment the counter
        sampleCount++;

        //3. Add the sample to the current total and calculate average
        averageTimeTaken = (currentTotal + sample) /sampleCount;
    }

    public double getAverageTimeTaken(){
        return this.averageTimeTaken;
    }
}
