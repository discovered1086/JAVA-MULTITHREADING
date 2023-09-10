package com.kingshuk.corejava.multithreadingcourse.lockfree.usingatomicclasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

/**
 * This class produces wrong results every time it runs because
 * Here we have a race condition between the addition and subtraction threads
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class AmountCalculator {

    private int totalAmount;

}

@AllArgsConstructor
class AdditionThread implements Runnable {

    private AmountCalculator amountCalculator;

    private int incrementValue;


    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 10; i++) {
            amountCalculator.setTotalAmount(amountCalculator.getTotalAmount() + incrementValue);
        }

    }
}

@AllArgsConstructor
class SubtractionThread implements Runnable {

    private AmountCalculator amountCalculator;

    private int decrementValue;


    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 10; i++) {
            amountCalculator.setTotalAmount(amountCalculator.getTotalAmount() - decrementValue);
        }

    }
}


public class IntegerConcurrencyCheckDemo {

    public static void main(String[] args) throws InterruptedException {
        AmountCalculator calculator = new AmountCalculator();
        Thread thread1 = new Thread(new AdditionThread(calculator, 500));
        Thread thread2 = new Thread(new SubtractionThread(calculator, 200));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("The final amount is: $" + calculator.getTotalAmount());
    }
}
