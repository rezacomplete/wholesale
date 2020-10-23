package com.example.wholesale.controller;

import com.example.wholesale.model.Account;
import com.example.wholesale.model.Transaction;
import com.example.wholesale.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountsResource {

    @Autowired
    AccountsService accountsService;

    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER')")
    @GetMapping(path="/api/v1/customers/{customerId}/accounts")
    public List<Account> retrieveCustomerAccounts(@PathVariable String customerId) {
        return accountsService.retrieveCustomerAccounts(customerId);
    }

    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER')")
    @GetMapping(path = "/api/v1/accounts/{accountNumber}/transactions")
    public List<Transaction> retrieveAccountTransactions(@PathVariable String accountNumber) {
        return accountsService.retrieveAccountTransactions(accountNumber);
    }
}
