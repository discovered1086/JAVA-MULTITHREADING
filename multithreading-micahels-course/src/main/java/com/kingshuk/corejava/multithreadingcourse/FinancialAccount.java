package com.kingshuk.corejava.multithreadingcourse;

import java.math.BigDecimal;

public interface FinancialAccount {

    BigDecimal getAccountBalance();

    void creditAccount(BigDecimal amount);

    void debitAccount(BigDecimal amount);
}
