package com.example.wholesale.controller;

import com.example.wholesale.model.Account;
import com.example.wholesale.model.Transaction;
import com.example.wholesale.service.AccountsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class AccountsResourceTest {

    private MockMvc mockMvc;

    @MockBean
    private AccountsService accountsService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void retrieveCustomerAccounts() throws Exception {
        List<Account> accounts = Collections.singletonList(new Account("123456", "reza", BigDecimal.TEN));

        when(accountsService.retrieveCustomerAccounts("123")).thenReturn(accounts);

        mockMvc.perform(get("/api/v1/customers/123/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"number\":\"123456\",\"name\":\"reza\",\"balance\":10}]"))
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void retrieveAccountTransactions() throws Exception {
        List<Transaction> transactions =
                Collections.singletonList(
                        new Transaction(
                                "123456",
                                BigDecimal.TEN,
                                LocalDateTime.of(2020, 10, 23, 10, 20)));

        when(accountsService.retrieveAccountTransactions("123456")).thenReturn(transactions);

        mockMvc.perform(get("/api/v1/accounts/123456/transactions"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"number\":\"123456\",\"amount\":10,\"time\":\"2020-10-23T10:20:00\"}]"))
                .andExpect(content().contentType("application/json"));
    }
}