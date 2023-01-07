package com.gerwais.bankaccount.domain.usecase;

import com.gerwais.bankaccount.domain.model.Account;
import com.gerwais.bankaccount.domain.model.User;
import com.gerwais.bankaccount.domain.port.AccountPort;

import java.math.BigDecimal;
import java.util.Optional;

import static java.time.LocalDateTime.now;

public class DepositUseCaseHandler {

    AccountPort accountPort;

    public DepositUseCaseHandler(AccountPort accountPort) {
        this.accountPort = accountPort;
    }

    void apply(User user, BigDecimal amount) {
        Optional<Account> account = accountPort.getAccount(user);
        if(account.isEmpty())
            return;

        var newBalance = account.get().getBalance().add(amount);
        var newAccount = new Account(now(), amount, newBalance, user);
        accountPort.saveAccount(newAccount);
    }
}
