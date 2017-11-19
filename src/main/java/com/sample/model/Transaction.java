package com.sample.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Yuriy
 */
public class Transaction {

    private final int id;
    private final int accountId;
    private final Date date;
    private final BigDecimal amount;

    public Transaction(int id, int accountId, Date date, BigDecimal amount) {
        this.id = id;
        this.accountId = accountId;
        this.date = date;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
