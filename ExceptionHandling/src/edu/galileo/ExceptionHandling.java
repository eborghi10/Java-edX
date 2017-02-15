package edu.galileo;

public class ExceptionHandling {

    public static void main(String[] args) throws Exception {

        // Limit $2000.00
        CreditCard card = new CreditCard(62656565,2000.0);
        System.out.println("Credit Card State:");
        System.out.println(card.getCreditState());

        try {
            System.out.println("\n\tBuying $1500.00");
            card.buy(1500.00);

            System.out.println("\nCredit Card State:");
            System.out.println(card.getCreditState());

            /**
             * Generates a custom exception
             *
             */
            System.out.println("\n\tBuying $800.00\n");
            card.buy(800.00);
        }catch(ExceededCreditCardLimitException e) {
            System.out.println("Invalid Buy, Limit Exceeded by " + e.getExceededAmount());
            e.printStackTrace(); //Print Stack Trace
        }
    }
}


class CreditCard {
    private double creditAvailable, limit;
    private int number;

    public CreditCard(int number, double limit) {
        this.number = number;
        this.creditAvailable = limit;
        this.limit = limit;
    }

    public void paidCreditCard(double amount) {
        /**
         * If we pay, part of the credit is restored
         *
         */
        creditAvailable += amount;
    }

    public void buy(double amount) throws ExceededCreditCardLimitException {
        /**
         * This method throws a custom exception called "ExceedCreditCardLimitException".
         *
         */
        if(amount <= creditAvailable) {
            this.creditAvailable -= amount;
        }else {
            double exceeded = amount - creditAvailable;
            throw new ExceededCreditCardLimitException(exceeded);
        }
    }

    public String getCreditState(){
        return "Credit Available: $" + this.creditAvailable + " Credit Limit: $" + this.limit;
    }

    public double getCreditAvailable() {
        return this.creditAvailable;
    }

    public double getLimit() {
        return this.limit;
    }

    public int getNumber() {
        return this.number;
    }
}

class ExceededCreditCardLimitException extends Exception {
    /**
     * Notice what type of exception is, by excess or by shortage.
     */
    private double exceededAmount;

    public ExceededCreditCardLimitException(double exceededAmount) {
        this.exceededAmount = exceededAmount;
    }

    public double getExceededAmount() {
        return exceededAmount;
    }
}