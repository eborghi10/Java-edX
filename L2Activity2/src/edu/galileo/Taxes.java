package edu.galileo;

/**
 * Created by emiliano on 31/01/17.
 */
public interface Taxes {
    double getGrossSalary();
    double getNetSalary();
    default double getTaxRate(double gross_salary) {
        if (gross_salary < 10000 ) {
            return 0.05;
        } else if (gross_salary >= 20000 && gross_salary < 50000) {
            return 0.10;
        } else {
            return 0.15;
        }
    }
}
