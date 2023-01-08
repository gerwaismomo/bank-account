package com.gerwais.bankaccount.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class HistoricAccount {

    private Operation operation;
    private LocalDateTime date;
    private BigDecimal amount;
    private BigDecimal balance;

    public HistoricAccount(Operation operation, LocalDateTime date, BigDecimal amount, BigDecimal balance) {
        this.operation = operation;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public HistoricAccount() {
    }

    public Operation getOperation() {
        return operation;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricAccount that = (HistoricAccount) o;
        return operation == that.operation && Objects.equals(date, that.date) && Objects.equals(amount, that.amount) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, date, amount, balance);
    }

    @Override
    public String toString() {
        return "HistoricAccount{" +
                "operation=" + operation +
                ", date=" + date +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }
}
