package edu.galileo.ac.atm;

// It's necessary to import the class "BankAccount" in order to use
// the class of another package.
import edu.galileo.ac.bank.BankAccount;

/**
 * Created by emiliano on 30/01/17.
 *
 * Referencing a class in other package
 */
public class ATM {
    private int id;

    public ATM(int id) {
        this.id = id;
    }

    public void withdraw(BankAccount account, double amount) {
        boolean result = account.withdraw(amount);
        if (result) {
            System.out.println("Successful withdraw on ATM of $" + amount);
        } else {
            System.out.println("Error on ATM");
        }
    }
}
