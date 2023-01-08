package com.gerwais.bankaccount.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account implements Serializable {

    private User user;
    private LocalDateTime date;
    private BigDecimal amount;
    private BigDecimal balance;

    public Account() {
    }

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

    public void setUser(User user) {
        this.user = user;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
