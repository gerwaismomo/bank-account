package com.gerwais.bankaccount.domain.port;

import com.gerwais.bankaccount.domain.model.User;

import java.math.BigDecimal;

public interface WithdrawUseCase {

    void apply(User user, BigDecimal amount);
}
