package com.gerwais.bankaccount.domain.port;

import com.gerwais.bankaccount.domain.model.Account;
import com.gerwais.bankaccount.domain.model.User;

import java.util.List;

public interface HistoryAccountPort {
    List<Account> getAccountHistory(User user);
}
