package edu.galileo;

/**
 * Created by emiliano on 31/01/17.
 *
 */
public class Manager extends Employee {

    public Manager(int years) {
        super(years);
    }

    @Override
    public double getBonus() {
        return super.getBonus() + 10000;
    }
}
