package com.gerwais.bankaccount.domain.port;

import com.gerwais.bankaccount.domain.model.HistoricAccount;
import com.gerwais.bankaccount.domain.model.User;

import java.util.List;

public interface HistoryAccountUsecase {
    List<HistoricAccount> apply(User user);
}
