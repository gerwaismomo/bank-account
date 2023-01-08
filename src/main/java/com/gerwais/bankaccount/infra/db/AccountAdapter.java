package com.gerwais.bankaccount.infra.db;

import com.gerwais.bankaccount.domain.model.Account;
import com.gerwais.bankaccount.domain.model.User;
import com.gerwais.bankaccount.domain.port.AccountPort;
import com.gerwais.bankaccount.domain.port.HistoryAccountPort;
import com.gerwais.bankaccount.infra.db.repository.AccountRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class AccountAdapter implements AccountPort, HistoryAccountPort {

    private final AccountRepository accountRepository;

    public AccountAdapter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> getAccount(User user) {
        var entity = accountRepository.findTopByUserOrderByDateDesc(user.getName());
        return entity.map(AccountMapper::toDomain);
    }

    @Override
    public Account saveAccount(Account account) {
        var entity = AccountMapper.toEntity(account);
        entity.setDate(LocalDateTime.now());
        entity = accountRepository.saveAndFlush(entity);
        return AccountMapper.toDomain(entity);
    }

    @Override
    public List<Account> getAccountHistory(User user) {
        return accountRepository.findAllByUserOrderByDateDesc(user.getName()).stream()
                .map(AccountMapper::toDomain)
                .toList();
    }
}
