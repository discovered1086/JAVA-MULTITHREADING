package com.kingshuk.corejava.multithreadingcourse.lockfree.usingatomicclasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class solves the problem we have in
 *     <code>com.kingshuk.corejava.multithreadingcourse.lockfree.usingatomicclasses.IntegerConcurrencyCheckDemo</code>
 * By using the <code> java.util.concurrent.AtomicInteger</code> class
 * @see java.util.concurrent.atomic.AtomicInteger
 * @see IntegerConcurrencyCheckDemo
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class AtomicAmountCalculator {

    private AtomicInteger totalAmount = new AtomicInteger();

}

@AllArgsConstructor
class AtomicAdditionThread implements Runnable {

    private AtomicAmountCalculator amountCalculator;

    private int incrementValue;


    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 10; i++) {
            amountCalculator.getTotalAmount().set(amountCalculator.getTotalAmount().addAndGet(incrementValue));
        }

    }
}

@AllArgsConstructor
class AtomicSubtractionThread implements Runnable {

    private AtomicAmountCalculator amountCalculator;

    private int decrementValue;


    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 10; i++) {
            amountCalculator.getTotalAmount().set(amountCalculator.getTotalAmount().addAndGet(-decrementValue));
        }

    }
}


public class LockFreeIntegerOperationDemo {

    public static void main(String[] args) throws InterruptedException {
        AtomicAmountCalculator calculator = new AtomicAmountCalculator();
        Thread thread1 = new Thread(new AtomicAdditionThread(calculator, 500));
        Thread thread2 = new Thread(new AtomicSubtractionThread(calculator, 200));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("The final amount is: $" + calculator.getTotalAmount().get());
    }
}
