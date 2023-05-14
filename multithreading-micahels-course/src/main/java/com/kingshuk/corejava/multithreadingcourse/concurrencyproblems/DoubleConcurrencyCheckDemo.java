package com.kingshuk.corejava.multithreadingcourse.concurrencyproblems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class AmountCalculator {

    private volatile double totalAmount;

}

@AllArgsConstructor
class AdditionThread implements Runnable {

    private AmountCalculator amountCalculator;

    private double incrementValue;


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            amountCalculator.setTotalAmount(amountCalculator.getTotalAmount() + incrementValue);
        }

    }
}

@AllArgsConstructor
class SubtractionThread implements Runnable {

    private AmountCalculator amountCalculator;

    private double decrementValue;


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            amountCalculator.setTotalAmount(amountCalculator.getTotalAmount() - decrementValue);
        }

    }
}


public class DoubleConcurrencyCheckDemo {

    public static void main(String[] args) throws InterruptedException {
        AmountCalculator calculator = new AmountCalculator();
        Thread thread1 = new Thread(new AdditionThread(calculator, 500.00));

        Thread thread2 = new Thread(new SubtractionThread(calculator, 200.00));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("The final amount is: $" + calculator.getTotalAmount());
    }
}
