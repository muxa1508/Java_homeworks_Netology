package org.example.accounts;

import org.junit.jupiter.api.*;

class CreditAccountsTest {

    protected CreditAccounts creditAccount;

    @BeforeAll
    static void setUPAll() {
        System.out.println("Запуск тестов для CreditAccounts");
    }

    @BeforeEach
    void setUp() {
        creditAccount = new CreditAccounts("CreditAccountTest");
    }

    @Test
    @DisplayName("Тест на возможность пополнение баланса кредитного счета больше нуля")
    void add() {
        Assertions.assertFalse(creditAccount.add(100));
    }

    @Test
    @DisplayName("Тест возможности списания любой положительной суммы")
    void pay() {
        Assertions.assertTrue(creditAccount.pay(100));
    }
}