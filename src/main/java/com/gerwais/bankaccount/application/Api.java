package com.gerwais.bankaccount.application;

import com.gerwais.bankaccount.domain.model.Account;
import com.gerwais.bankaccount.domain.model.HistoricAccount;
import com.gerwais.bankaccount.domain.model.User;
import com.gerwais.bankaccount.domain.port.DepositUseCase;
import com.gerwais.bankaccount.domain.port.HistoryAccountUsecase;
import com.gerwais.bankaccount.domain.port.WithdrawUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "/bank-account")
public class Api {

    private final DepositUseCase depositUseCase;
    private final WithdrawUseCase withdrawUseCase;
    private final HistoryAccountUsecase historyAccountUsecase;

    public Api(DepositUseCase depositUseCase, WithdrawUseCase withdrawUseCase, HistoryAccountUsecase historyAccountUsecase) {
        this.depositUseCase = depositUseCase;
        this.withdrawUseCase = withdrawUseCase;
        this.historyAccountUsecase = historyAccountUsecase;
    }

    @PostMapping(path = "/{user}/deposit/{amount}")
    public ResponseEntity<Account> deposit(@PathVariable("user") String user, @PathVariable("amount") BigDecimal amount) {
        var result = this.depositUseCase.apply(new User(user), amount);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping(path = "/{user}/withdraw/{amount}")
    public ResponseEntity<Account> withdraw(@PathVariable("user") String user, @PathVariable("amount") BigDecimal amount) {
        var result = this.withdrawUseCase.apply(new User(user), amount);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping(path = "/{user}/historic")
    public ResponseEntity<List<HistoricAccount>> historic(@PathVariable("user") String user) {

        return ResponseEntity.ok(this.historyAccountUsecase.apply(new User(user)));
    }


}
