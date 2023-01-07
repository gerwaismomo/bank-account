package com.gerwais.bankaccount.domain.usecase;

import com.gerwais.bankaccount.domain.model.Account;
import com.gerwais.bankaccount.domain.model.User;
import com.gerwais.bankaccount.domain.port.AccountPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.ZERO;
import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WithdrawUseCaseHandlerTest {

    @Mock
    AccountPort accountPort;
    WithdrawUseCaseHandler handler;

    @Captor
    ArgumentCaptor<Account> accountCaptor;

    private User user;
    private BigDecimal amount;

    @BeforeEach
    void init() {
        handler = new WithdrawUseCaseHandler(accountPort);
    }

    @Test
    void apply_shouldDoNothing_whenUserHasNoAccount() {
        givenUser();
        givenUserHasNoAccount();
        whenApplyIsInvoked();
        thenNoAccountUpdated();
    }

    @Test
    void apply_shouldSaveAccountWithWithdrawedAmount_whenUserHasAccount() {
        givenUser();
        givenAmountToWithdrawIs10();
        givenUserHasAccountWithBalance10();
        whenApplyIsInvoked();
        thenAccountNewBalanceIs0();
    }

    private void givenUser() {
        user = user1();
    }

    private User user1() {
        return new User("user1");
    }

    private void givenUserHasNoAccount() {
        given(accountPort.getAccount(any(User.class))).willReturn(Optional.empty());
    }

    private void givenUserHasAccountWithBalance10() {
        given(accountPort.getAccount(any(User.class))).willReturn(Optional.of(accountOf10()));
        given(accountPort.saveAccount(accountCaptor.capture())).willReturn(Optional.of(new Account(now(), ZERO, ZERO, user1())));

    }

    private void givenAmountToWithdrawIs10() {
        this.amount = TEN;
    }


    private void whenApplyIsInvoked() {
        handler.apply(user, amount);
    }

    private void thenNoAccountUpdated() {
        verify(accountPort, never()).saveAccount(any(Account.class));
    }

    private void thenAccountNewBalanceIs0() {
        var accountArg = accountCaptor.getValue();
        assertEquals(amount.negate(), accountArg.getAmount());
        assertEquals(ZERO, accountArg.getBalance());

    }

    private Account accountOf10() {
        return new Account(now(), ZERO, TEN, user1());
    }

}
