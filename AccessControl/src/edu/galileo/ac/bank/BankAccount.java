package edu.galileo.ac.bank;

/**
 * Created by emiliano on 30/01/17.
 */
public class BankAccount {
    // Public and private attributes
    public int number;
    private double balance; // Can be used ONLY inside this class

    public BankAccount(int number, double balance) {
        // Public constructor -> to be used outside this package
        // Initialize the OBJECT's ATTRIBUTES
        this.number = number;
        this.balance = balance;
    }

    protected boolean deposit(double amount) {
        // Method with PROTECTED ACCESS MODIFIER

        /*
         * In order to use this PROTECTED modifier, it's
         * necessary to create another class ("BankTeller")
         * inside this package.
         */

        if(amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        // amount :: Extraer, retirar
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
