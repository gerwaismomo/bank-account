package com.gerwais.bankaccount.domain.usecase;

import com.gerwais.bankaccount.domain.model.Account;
import com.gerwais.bankaccount.domain.model.User;
import com.gerwais.bankaccount.domain.port.HistoryAccountPort;

import java.util.List;

import static java.util.Objects.isNull;

public class HistoryAccountUsecaseHandler {

    private HistoryAccountPort historyAccountPort;

    public HistoryAccountUsecaseHandler(HistoryAccountPort historyAccountPort) {
        this.historyAccountPort = historyAccountPort;
    }

    public List<Account> apply(User user) {
        if(isNull(user))
            return List.of();

        return this.historyAccountPort.getAccountHistory(user);
    }
}
