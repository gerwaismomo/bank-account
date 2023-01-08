package com.gerwais.bankaccount.domain.usecase;

import com.gerwais.bankaccount.domain.model.Account;
import com.gerwais.bankaccount.domain.model.HistoricAccount;
import com.gerwais.bankaccount.domain.model.User;
import com.gerwais.bankaccount.domain.port.HistoryAccountPort;
import com.gerwais.bankaccount.domain.port.HistoryAccountUsecase;

import java.util.List;

import static com.gerwais.bankaccount.domain.model.Operation.DEPOSIT;
import static com.gerwais.bankaccount.domain.model.Operation.WITHDRAW;
import static java.math.BigDecimal.ZERO;
import static java.util.Objects.isNull;

public class HistoryAccountUsecaseHandler implements HistoryAccountUsecase {

    private final HistoryAccountPort historyAccountPort;

    public HistoryAccountUsecaseHandler(HistoryAccountPort historyAccountPort) {
        this.historyAccountPort = historyAccountPort;
    }

    @Override
    public List<HistoricAccount> apply(User user) {
        if (isNull(user))
            return List.of();

        var accounts = this.historyAccountPort.getAccountHistory(user);

        return accounts.stream()
                .sorted((a, b) -> a.getDate().compareTo(b.getDate()))
                .map(this::toHistoric)
                .toList();
    }

    private HistoricAccount toHistoric(Account account) {
        var operation = account.getAmount().compareTo(ZERO) < 0 ? WITHDRAW : DEPOSIT;
        return new HistoricAccount(operation, account.getDate(), account.getAmount(), account.getBalance());
    }
}
