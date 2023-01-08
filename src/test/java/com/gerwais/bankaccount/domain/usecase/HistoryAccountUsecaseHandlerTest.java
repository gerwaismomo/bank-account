package com.gerwais.bankaccount.domain.usecase;

import com.gerwais.bankaccount.domain.model.Account;
import com.gerwais.bankaccount.domain.model.HistoricAccount;
import com.gerwais.bankaccount.domain.model.User;
import com.gerwais.bankaccount.domain.port.HistoryAccountPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.gerwais.bankaccount.domain.model.Operation.DEPOSIT;
import static com.gerwais.bankaccount.domain.model.Operation.WITHDRAW;
import static java.math.BigDecimal.TEN;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    private List<HistoricAccount> historic;
    private LocalDateTime now;

    @BeforeEach
    void init() {
        now = LocalDateTime.now();
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
        historic = handler.apply(user);
    }

    private void thenReturnSortedOperations() {
        verify(historyAccountPort, times(1)).getAccountHistory(user);
        assertEquals(sortedHistoric().get(0), historic.get(0));
        assertEquals(sortedHistoric().get(1), historic.get(1));
        assertEquals(sortedHistoric().get(2), historic.get(2));
    }

    private User user1() {
        return new User("user1");
    }

    private List<Account> unsortedOperations() {

        var account1 = new Account(now, TEN, TEN, user1());
        var account2 = new Account(now.plusHours(2), TEN.negate(), TEN, user1());
        var account3 = new Account(now.plusHours(1), TEN, BigDecimal.valueOf(20), user1());
        return List.of(account1, account2, account3);
    }

    private List<HistoricAccount> sortedHistoric() {
        var account1 = new HistoricAccount(DEPOSIT, now, TEN, TEN);
        var account2 = new HistoricAccount(DEPOSIT, now.plusHours(1), TEN, BigDecimal.valueOf(20));
        var account3 = new HistoricAccount(WITHDRAW, now.plusHours(2), TEN, TEN);
        return List.of(account1, account2, account3);
    }
}
