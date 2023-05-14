package com.kingshuk.corejava.multithreadingcourse.concurrencyproblems.synchronizedcode;

import com.kingshuk.corejava.multithreadingcourse.FinancialAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BankAccountSynchronized implements FinancialAccount {
    private BigDecimal accountBalance;

    public synchronized void creditAccount(BigDecimal amount) {
        this.accountBalance = this.accountBalance.add(amount);
    }

    public synchronized void debitAccount(BigDecimal amount) {
        this.accountBalance = this.accountBalance.subtract(amount);
    }
}
