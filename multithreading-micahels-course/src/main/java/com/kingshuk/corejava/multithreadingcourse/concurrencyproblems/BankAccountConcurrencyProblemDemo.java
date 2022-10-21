package com.kingshuk.corejava.multithreadingcourse.concurrencyproblems;

import com.kingshuk.corejava.multithreadingcourse.FinancialAccount;

import java.math.BigDecimal;

public class BankAccountConcurrencyProblemDemo {

    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(BigDecimal.valueOf(10000));
        threadExecution(account);
    }

    public static void threadExecution(FinancialAccount account) throws InterruptedException {
        Thread creditorThread = new Thread(new CreditAccountThread<>(account));
        Thread debitThread = new Thread(new DebitAccountThread<>(account));

        creditorThread.start();

        debitThread.start();

        debitThread.join();
        creditorThread.join();

        System.out.println("The final account balance is: " + account.getAccountBalance());
    }
}
