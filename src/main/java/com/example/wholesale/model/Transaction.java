package com.example.wholesale.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private final String number;
    private final BigDecimal amount;
    private final LocalDateTime time;

    public Transaction(String number, BigDecimal amount, LocalDateTime time) {
        this.number = number;
        this.amount = amount;
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
