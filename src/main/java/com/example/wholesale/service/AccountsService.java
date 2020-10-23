package com.example.wholesale.service;

import com.example.wholesale.model.Account;
import com.example.wholesale.model.Transaction;
import com.example.wholesale.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService {

    @Autowired
    AccountsRepository accountsRepository;


    public List<Account> retrieveCustomerAccounts(String customerId) {
        return accountsRepository.findCustomerAccounts(customerId);
    }

    public List<Transaction> retrieveAccountTransactions(String accountNumber) {
        return accountsRepository.findAccountTransactions(accountNumber);
    }
}
