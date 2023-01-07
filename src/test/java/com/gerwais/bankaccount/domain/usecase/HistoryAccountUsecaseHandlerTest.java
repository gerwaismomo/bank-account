package com.gerwais.bankaccount.domain.usecase;

import com.gerwais.bankaccount.domain.model.Account;
import com.gerwais.bankaccount.domain.model.User;
import com.gerwais.bankaccount.domain.port.HistoryAccountPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class HistoryAccountUsecaseHandlerTest {

    @Mock
    HistoryAccountPort historyAccountPort;
    HistoryAccountUsecaseHandler handler;

    private User user;

    @BeforeEach
    void init() {
        handler = new HistoryAccountUsecaseHandler(historyAccountPort);
    }

    @Test
    void apply_shouldReturnSortedOperations_whenUserHasOperations() {
        givenUser();
        givenOperationsOnUser();
        whenApplyIsInvoked();
        thenReturnSortedOperations();
    }

    private void givenUser() {
        user = user1();
    }

    private void givenOperationsOnUser() {
        given(historyAccountPort.getAccountHistory(any(User.class))).willReturn(unsortedOperations());
    }

    private void whenApplyIsInvoked() {
        handler.apply(user);
    }

    private void thenReturnSortedOperations() {
        verify(historyAccountPort, times(1)).getAccountHistory(user);
    }

    private User user1() {
        return new User("user1");
    }

    private List<Account> unsortedOperations() {

        return List.of();
    }
}
