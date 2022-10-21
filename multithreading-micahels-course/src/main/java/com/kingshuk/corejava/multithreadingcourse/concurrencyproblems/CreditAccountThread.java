package com.kingshuk.corejava.multithreadingcourse.concurrencyproblems;

import com.kingshuk.corejava.multithreadingcourse.FinancialAccount;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class CreditAccountThread<T extends FinancialAccount> implements Runnable {
    private T account;

    @Override
    public void run() {
        account.creditAccount(BigDecimal.valueOf(600));
        account.creditAccount(BigDecimal.valueOf(950));
        account.creditAccount(BigDecimal.valueOf(450));
    }
}
