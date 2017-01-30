package edu.galileo.ac.bank;

/**
 * Created by emiliano on 30/01/17.
 */
public class BankTeller {
    // Bank Teller :: cajero

    /*
     * It contains 2 public METHODS.
     */

    public void deposit(BankAccount account, double amount) {
        boolean result = account.deposit(amount);
        if(result) {
            System.out.println("Successful deposit of $" + amount);
        } else {
            System.out.println("Error on deposit!!");
        }
    }

    public void withdraw(BankAccount account, double amount) {
        boolean result = account.withdraw(amount);
        if(result) {
            System.out.println("Successful withdraw of $" + amount);
        } else {
            System.out.println("Error on withdraw!!");
        }
    }

}
