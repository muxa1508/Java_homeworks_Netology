package org.example.accounts;

import org.junit.jupiter.api.*;

class SavingsAccountTest {

    private SavingsAccount savingsAccount;

    @BeforeAll
    static void setUPAll() {
        System.out.println("Запуск тестов для SavingAccount");
    }

    @BeforeEach
    void setUP() {
        savingsAccount = new SavingsAccount("SavingsAccountTest", 10000, 1000);
    }

    @Test
    @DisplayName("Тест пополнения сберегательного счета")
    void add() {
        Assertions.assertTrue(savingsAccount.add(1000));
    }

    @Test
    @DisplayName("Тест покупки со сберегательного счета на сумму, которая уменьшит баланс ниже минимального значения")
    void pay() {
        Assertions.assertFalse(savingsAccount.pay(9000));
    }

    @Test
    @DisplayName("Тест покупки со сберегательного счета на сумму, которая НЕ уменьшит баланс ниже минимального значения")
    void pay2() {
        Assertions.assertTrue(savingsAccount.pay(8999));
    }
}