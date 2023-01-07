package com.gerwais.bankaccount.domain.usecase;

import com.gerwais.bankaccount.domain.model.User;
import com.gerwais.bankaccount.domain.port.AccountPort;

public class DepositUseCaseHandler {

    AccountPort accountPort;

    public DepositUseCaseHandler(AccountPort accountPort) {
        this.accountPort = accountPort;
    }

    void apply(User user) {

    }
}
