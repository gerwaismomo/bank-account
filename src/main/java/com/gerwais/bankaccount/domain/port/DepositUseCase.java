package com.gerwais.bankaccount.domain.port;

import com.gerwais.bankaccount.domain.model.User;

import java.math.BigDecimal;

public interface DepositUseCase {

    void apply(User user, BigDecimal amount);
}
