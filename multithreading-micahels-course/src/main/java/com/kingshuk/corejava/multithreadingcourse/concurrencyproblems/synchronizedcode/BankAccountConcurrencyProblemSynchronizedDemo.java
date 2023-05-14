package com.kingshuk.corejava.multithreadingcourse.concurrencyproblems.synchronizedcode;

import com.kingshuk.corejava.multithreadingcourse.concurrencyproblems.BankAccount;
import com.kingshuk.corejava.multithreadingcourse.concurrencyproblems.CreditAccountThread;
import com.kingshuk.corejava.multithreadingcourse.concurrencyproblems.DebitAccountThread;

import java.math.BigDecimal;

import static com.kingshuk.corejava.multithreadingcourse.concurrencyproblems.BankAccountConcurrencyProblemDemo.threadExecution;

public class BankAccountConcurrencyProblemSynchronizedDemo {

    public static void main(String[] args) throws InterruptedException {
        BankAccountSynchronized account = new BankAccountSynchronized(BigDecimal.valueOf(10000));
        threadExecution(account);
    }
}
