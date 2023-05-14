package com.kingshuk.corejava.multithreadingcourse.concurrencyproblems;

import com.kingshuk.corejava.multithreadingcourse.FinancialAccount;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class DebitAccountThread<T extends FinancialAccount> implements Runnable {
    private T account;

    @Override
    public void run() {
        account.debitAccount(BigDecimal.valueOf(500));
        account.debitAccount(BigDecimal.valueOf(200));
        account.debitAccount(BigDecimal.valueOf(650));
    }
}
