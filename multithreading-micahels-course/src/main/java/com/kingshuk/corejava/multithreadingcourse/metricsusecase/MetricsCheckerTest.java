package com.kingshuk.corejava.multithreadingcourse.metricsusecase;

public class MetricsCheckerTest {

    public static void main(String[] args) {
        MetricsCalculator calculator = new MetricsCalculator();
        BusinessLogic logic1 = new BusinessLogic(calculator);
        BusinessLogic logic2 = new BusinessLogic(calculator);
        MetricsPrinter printer = new MetricsPrinter(calculator);

        logic1.start();
        logic2.start();
        printer.start();
    }
}
