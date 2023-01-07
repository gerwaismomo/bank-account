package com.gerwais.bankaccount.domain.usecase;

import com.gerwais.bankaccount.domain.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HistoryAccountUsecaseHandlerTest {

    HistoryAccountUsecaseHandler handler;

    private User user;

    @Test
    void apply_shouldReturnSortedOperations_whenUserHasOperations() {
        givenUser();
        whenApplyIsInvoked();
    }

    private void givenUser() {
        user = user1();
    }

    private void whenApplyIsInvoked() {
        handler.apply(user);
    }

    private User user1() {
        return new User("user1");
    }


}
