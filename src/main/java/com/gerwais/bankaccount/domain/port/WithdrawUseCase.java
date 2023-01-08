package com.gerwais.bankaccount.domain.port;

import com.gerwais.bankaccount.domain.model.Account;
import com.gerwais.bankaccount.domain.model.User;

import java.math.BigDecimal;
import java.util.Optional;

public interface WithdrawUseCase {

    Optional<Account> apply(User user, BigDecimal amount);
}
