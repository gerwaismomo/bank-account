package com.gerwais.bankaccount.domain.port;

import com.gerwais.bankaccount.domain.model.Account;
import com.gerwais.bankaccount.domain.model.User;

import java.util.Optional;

public interface AccountPort {
    Optional<Account> getAccount(User user);
    Account saveAccount(Account account);
}
