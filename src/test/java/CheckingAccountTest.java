import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class CheckingAccountTest {

    private CheckingAccount account;

    @BeforeEach
    void setUpAccount() throws IllegalArgumentException {
        account = new CheckingAccount("ES13343343445", 2000, -500);
    }

    @Test
    @DisplayName("Podemos depositar dinero")
    void widwithdrawNegativeAmmount() throws IllegalArgumentException {
        account.deposit(1000);
        assertEquals(3000, account.getBalance());
    }

    @Test
    @DisplayName("Deposito con cantidad negativa que lanza una excepcion")
    void depositoCantidadNegativa() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
    }

    @Test
    @DisplayName("Intentamos sacar mas dinero del que tenemos")
    void withdrawMoreThanBalance() throws InsufficientFundsException {
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(4000));
    }

    @Test
    @DisplayName("Le paso un sobregiro superior al limite")
    void withdrawWithOverdraftLimitMoreOverHead() throws InsufficientFundsException {
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(3500));
    }




}