package edu.galileo;

/*
 * The following program has to calculate the
 * yearly salaries of employees.
 *
 * TODO:
 * 1) Make sure the class Employee implements the interface Taxes.
 *
 * 2) Define the method getGrossSalary() within Employee class.
 * Assume that the gross salary is equal to the following equation:
 *      Base salary + Time employed bonus
 * Where:
 *      Base salary = $40000/year
 *      Time employed bonus = $1000/year employed
 *
 * 3) Define the method getNetSalary() within Employee class.
 * Assume that the net salary is equal to the following equation:
 *      Gross salary - (Gross salary * Tax rate)
 * Note:
 *  Tax rate should be obtained by invoking the getTaxRate()
 *  static method located within the interface Taxes.
 *
 * 4) Create a child class Manager that inherits from the class Employee.
 * Override the method getBonus() so that each manager gets an extra
 * $10000 additional to the time employed bonus.
 *
 **/

public class Main {

    public static void main(String[] args) {
        Employee jackie = new Employee(6);
        Employee joe = new Manager(8);

        System.out.println("Jackie Gross Salary: " + jackie.getGrossSalary() + " Net Salary " + jackie.getNetSalary());
        System.out.println("Joe Gross Salary: " + joe.getGrossSalary() + " Net Salary " + joe.getNetSalary());

        /* ANSWER
            Jackie Gross Salary: 46000.0 Net Salary 41400.0
            Joe Gross Salary: 58000.0 Net Salary 49300.0
        */
    }
}
