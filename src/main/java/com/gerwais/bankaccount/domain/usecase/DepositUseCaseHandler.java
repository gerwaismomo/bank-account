package com.gerwais.bankaccount.domain.usecase;

import com.gerwais.bankaccount.domain.model.Account;
import com.gerwais.bankaccount.domain.model.User;
import com.gerwais.bankaccount.domain.port.AccountPort;

import java.util.Optional;

public class DepositUseCaseHandler {

    AccountPort accountPort;

    public DepositUseCaseHandler(AccountPort accountPort) {
        this.accountPort = accountPort;
    }

    void apply(User user) {
        Optional<Account> account = accountPort.getAccount(user);
        if(account.isEmpty())
            return;

    }
}
