package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount(1000);
        account.withdraw(400);
        assertEquals(600, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientBalance() {
        BankAccount account = new BankAccount(500);
        assertThrows(IllegalStateException.class, () -> {
            account.withdraw(800);
        });
    }

    @Test
    void testDepositInvalidAmount() {
        BankAccount account = new BankAccount(500);
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100);
        });
    }

    @Test
    void testWithdrawInvalidAmount() {
        BankAccount account = new BankAccount(500);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(0);
        });
    }
}