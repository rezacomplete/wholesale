package com.example.wholesale.repository;

import com.example.wholesale.model.Account;
import com.example.wholesale.model.Transaction;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountsRepository {
    public List<Account> findCustomerAccounts(String customerId) {
        List<Account> accounts = new ArrayList<>();

        // Should read from database
        if ("123".equalsIgnoreCase(customerId)) {
            Account account1 = new Account("123456", "John Smith", BigDecimal.valueOf(1_000_000));
            accounts.add(account1);

            Account account2 = new Account("654321", "John Smith", BigDecimal.valueOf(100_000));
            accounts.add(account2);
        }

        return accounts;
    }

    public List<Transaction> findAccountTransactions(String accountNumber) {
        List<Transaction> transactions = new ArrayList<>();

        // Should read from database
        switch (accountNumber) {
            case "123456":
                Transaction transaction1 = new Transaction("2354667", BigDecimal.valueOf(100), LocalDateTime.now());
                transactions.add(transaction1);
                break;
            case "654321":
                Transaction transaction2 = new Transaction("9856432", BigDecimal.valueOf(200), LocalDateTime.now());
                transactions.add(transaction2);
                break;
        }

        return transactions;

    }
}
