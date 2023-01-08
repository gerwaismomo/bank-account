package com.gerwais.bankaccount.infra.db.entity;

import com.gerwais.bankaccount.domain.model.User;
import jakarta.persistence.*;
import org.springframework.stereotype.Indexed;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(indexes = {
        @Index(name = "user_name", columnList = "userr")
})
public class AccountEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "userr", nullable = false)
    private String user;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    private BigDecimal amount;
    private BigDecimal balance;

    public AccountEntity() {
    }

    public AccountEntity(String user, LocalDateTime date, BigDecimal amount, BigDecimal balance) {
        this.user = user;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
