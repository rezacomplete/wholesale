package com.example.wholesale.service;

import com.example.wholesale.WholesaleApplication;
import com.example.wholesale.model.Account;
import com.example.wholesale.model.Transaction;
import com.example.wholesale.repository.AccountsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WholesaleApplication.class },
        initializers = ConfigFileApplicationContextInitializer.class)
class AccountsServiceTest {

    @Mock
    AccountsRepository accountsRepository;

    AccountsService accountsService;

    @BeforeEach
    void setUp() {
        this.accountsService = new AccountsService();
        this.accountsService.accountsRepository = accountsRepository;
    }

    @Test
    void retrieveCustomerAccounts() {
        List<Account> accounts = Collections.singletonList(new Account("123456", "reza", BigDecimal.TEN));

        when(accountsRepository.findCustomerAccounts("123")).thenReturn(accounts);
        List<Account> result = accountsService.retrieveCustomerAccounts("123");
        verify(accountsRepository, times(1)).findCustomerAccounts("123");
        assertEquals(BigDecimal.TEN, result.get(0).getBalance());

    }

    @Test
    void retrieveAccountTransactions() {
        List<Transaction> transactions =
                Collections.singletonList(
                        new Transaction(
                                "123456",
                                BigDecimal.TEN,
                                LocalDateTime.of(2020, 10, 23, 10, 20)));

        when(accountsRepository.findAccountTransactions("123456")).thenReturn(transactions);
        List<Transaction> result = accountsService.retrieveAccountTransactions("123456");
        verify(accountsRepository, times(1)).findAccountTransactions("123456");
        assertEquals(BigDecimal.TEN, result.get(0).getAmount());
    }
}