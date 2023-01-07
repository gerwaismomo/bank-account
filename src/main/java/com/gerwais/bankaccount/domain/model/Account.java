package com.gerwais.bankaccount.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account {

    private final User user;
    private LocalDateTime date;
    private BigDecimal amount;
    private BigDecimal balance;

    public Account(LocalDateTime date, BigDecimal amount, BigDecimal balance, User user) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }
}
