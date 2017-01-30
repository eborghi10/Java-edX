package edu.galileo.ac;

/*
 * We create a "edu.galileo.ac.bank" package inside the package "edu.galileo.ac"
 */

import edu.galileo.ac.atm.ATM;
import edu.galileo.ac.bank.BankAccount;
import edu.galileo.ac.bank.BankTeller;

public class Main {

    public static void main(String[] args) {
        BankAccount a = new BankAccount(1234, 100.00);
        BankAccount b = new BankAccount(1253, 200.00);

        /*
         * I do the operations of [protected] deposit() and [public] withdraw() through:
         * - [protected] A public method in the same package
         * - [public] From another package method.
         */

        BankTeller john = new BankTeller();
        john.deposit(a, 100.00);

        ATM xyz = new ATM(222);
        xyz.withdraw(b, 100.00);
    }
}
