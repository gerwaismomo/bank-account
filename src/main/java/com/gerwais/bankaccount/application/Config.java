package com.gerwais.bankaccount.application;

import com.gerwais.bankaccount.domain.model.Account;
import com.gerwais.bankaccount.domain.model.User;
import com.gerwais.bankaccount.domain.port.*;
import com.gerwais.bankaccount.domain.usecase.DepositUseCaseHandler;
import com.gerwais.bankaccount.domain.usecase.HistoryAccountUsecaseHandler;
import com.gerwais.bankaccount.domain.usecase.WithdrawUseCaseHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Configuration
public class Config {

    @Bean
    public DepositUseCase depositUseCase(AccountPort accountPort) {
        return new DepositUseCaseHandler(accountPort);
    }

    @Bean
    public WithdrawUseCase withdrawUseCase(AccountPort accountPort) {
        return new WithdrawUseCaseHandler(accountPort);
    }

    @Bean
    public HistoryAccountUsecase historyAccountUsecase(HistoryAccountPort historyAccountPort) {
        return new HistoryAccountUsecaseHandler(historyAccountPort);
    }


    /*private AccountPort accountPort() {
        return new AccountPort() {
            @Override
            public Optional<Account> getAccount(User user) {
                return Optional.of(new Account(LocalDateTime.now(), BigDecimal.TEN, BigDecimal.TEN, user));
            }

            @Override
            public Account saveAccount(Account account) {
                return account;
            }
        };
    }

    private HistoryAccountPort historyAccountPort() {
        return new HistoryAccountPort() {
            @Override
            public List<Account> getAccountHistory(User user) {
                return List.of();
            }
        };
    }*/
}
