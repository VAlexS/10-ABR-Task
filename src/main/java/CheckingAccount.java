// CUENTA CORRIENTE
public class CheckingAccount extends AbstractBankAccount {
    // una cuenta corriente permite sobregiro, es decir tener el balance negativo (hasta cierto límite)
    private double overdraftLimit; // límite de sobregiro

    public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit) throws IllegalArgumentException {
        super(accountNumber, initialBalance);

        if (overdraftLimit > 0) {
            throw new IllegalArgumentException("El límite de sobregiro no puede ser positivo");
        }

        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws IllegalArgumentException, InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("La cantidad a retirar debe ser mayor a 0");
        }

        if (getBalance() - overdraftLimit < amount) {
            // ejemplo: tengo 1000 y el límite es -100 y quiero sacar 1200
            throw new InsufficientFundsException("Fondos insuficientes. \n Tu saldo es de: " + getBalance() + "Y el límite de sobregiro es: " + overdraftLimit);
        }
    }


}









