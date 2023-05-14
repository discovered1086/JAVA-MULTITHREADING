package com.kingshuk.corejava.multithreadingcourse.concurrencyproblems;

import com.kingshuk.corejava.multithreadingcourse.FinancialAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BankAccount implements FinancialAccount {
    private BigDecimal accountBalance;

    public void creditAccount(BigDecimal amount) {
        this.accountBalance = this.accountBalance.add(amount);
    }

    public void debitAccount(BigDecimal amount) {
        this.accountBalance = this.accountBalance.subtract(amount);
    }
}
