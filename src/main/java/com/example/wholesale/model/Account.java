package com.example.wholesale.model;

import java.math.BigDecimal;

public class Account {

    private final String number;
    private final String name;
    private final BigDecimal balance;

    public Account(String number, String name, BigDecimal balance) {
        this.number = number;
        this.name = name;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
