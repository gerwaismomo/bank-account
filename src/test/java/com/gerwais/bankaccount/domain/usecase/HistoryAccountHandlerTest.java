package com.gerwais.bankaccount.domain.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HistoryAccountHandlerTest {


    @Test
    void apply_shouldReturnSortedOperations_whenUserHasOperations() {
        givenUser();
    }
}
