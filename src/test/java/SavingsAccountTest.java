import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    private SavingsAccount account;

    @BeforeEach
    void setUpAccount() throws IllegalArgumentException {
        account = new SavingsAccount("SA00002", 1000);
    }

    @Test
    @DisplayName("Podemos depositar dinero")
    void successfulDeposit() throws IllegalArgumentException {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    @DisplayName("Depósito con cantidad negativa lanza una excepción")
    void depositNegativeAmountException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
    }

    @Test
    @DisplayName("Debe saltar error si retiramos más dinero del que tenemos")
    void withdrawMoreThanBalance() throws InsufficientFundsException {
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(100000));
    }
}