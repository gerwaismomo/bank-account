package com.gerwais.bankaccount.domain.usecase;

import com.gerwais.bankaccount.domain.model.Account;
import com.gerwais.bankaccount.domain.model.User;
import com.gerwais.bankaccount.domain.port.AccountPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DepositUseCaseHandlerTest {

    @Mock
    AccountPort accountPort;
    DepositUseCaseHandler handler;

    private User user;

    @BeforeEach
    void init() {
        handler = new DepositUseCaseHandler(accountPort);
    }


    @Test
    void apply_shouldDoNothing_whenUserHasNoAccount() {
        givenUser();
        givenUserHasNoAccount();
        whenApplyIsInvoked();
        thenNoAccountUpdated();
    }

    @Test
    void apply_shouldDoSaveAccountWithAddedAmount_whenUserHasAccount() {
        givenUser();
        givenAmountToDeposit();
        givenUserHasAccount();
        whenApplyIsInvoked();
        thenNoAccountUpdated();
    }

    private void givenUserHasNoAccount() {
        given(accountPort.getAccount(any(User.class))).willReturn(Optional.empty());
    }
    private void givenUser() {
        user = new User("user1");
    }
    private void whenApplyIsInvoked() {
        handler.apply(user);
    }

    private void thenNoAccountUpdated() {
        verify(accountPort, never()).saveAccount(any(Account.class));
    }
}
