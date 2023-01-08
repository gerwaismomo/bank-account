package com.gerwais.bankaccount.infra.db;

import com.gerwais.bankaccount.domain.model.Account;
import com.gerwais.bankaccount.domain.model.User;
import com.gerwais.bankaccount.infra.db.entity.AccountEntity;

public interface AccountMapper {

    static Account toDomain(AccountEntity entity) {

        return new Account(entity.getDate(), entity.getAmount(), entity.getBalance(), new User(entity.getUser()));
    }

    static AccountEntity toEntity(Account entity) {

        return new AccountEntity(entity.getUser().getName(), entity.getDate(), entity.getAmount(), entity.getBalance());
    }
}
