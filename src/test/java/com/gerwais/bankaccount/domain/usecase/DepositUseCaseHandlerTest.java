package com.gerwais.bankaccount.domain.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class DepositUseCaseHandlerTest {

    DepositUseCaseHandler handler;

    @Test
    void apply_shouldDoNothing_whenUserHasNoAccount() {
        givenUserHasAccount();
    }

    private void givenUserHasAccount() {
        given(AccountRepository.findByOwner());
    }
}
