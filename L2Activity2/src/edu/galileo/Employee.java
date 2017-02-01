package edu.galileo;

/**
 * Created by emiliano on 31/01/17.
 */
public class Employee implements Taxes {
    private double baseSalary = 40000;
    private int years;

    public Employee(int years) {
        this.years = years;
    }

    public double getBonus() {
        return years*1000;
    }

    @Override
    public double getGrossSalary() {
        return this.baseSalary + getBonus();
    }

    @Override
    public double getNetSalary() {
        double grossSalary = getGrossSalary();
        return grossSalary - ( grossSalary * this.getTaxRate(grossSalary) );
    }
}
