package com.sample.model;

public class Account {

    private Integer balance;
    private final int id;

    public Account(int id, Integer balance) {
        super();
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void withdraw(int money) {
        balance -= money;
    }
}
