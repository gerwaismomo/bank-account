package com.gerwais.bankaccount.domain.usecase;

import com.gerwais.bankaccount.domain.model.Account;
import com.gerwais.bankaccount.domain.model.User;
import com.gerwais.bankaccount.domain.port.AccountPort;
import com.gerwais.bankaccount.domain.port.WithdrawUseCase;

import java.math.BigDecimal;
import java.util.Optional;

import static java.time.LocalDateTime.now;

public class WithdrawUseCaseHandler implements WithdrawUseCase {

    private AccountPort accountPort;

    public WithdrawUseCaseHandler(AccountPort accountPort) {
        this.accountPort = accountPort;
    }

    @Override
    public void apply(User user, BigDecimal amount) {
        Optional<Account> account = accountPort.getAccount(user);
        if (account.isEmpty())
            return;

        var newBalance = account.get().getBalance().subtract(amount);
        var newAccount = new Account(now(), amount.negate(), newBalance, user);
        accountPort.saveAccount(newAccount);
    }
}
