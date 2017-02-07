package edu.galileo;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception{
        /*
         * Every should be responsible of one thing.
         */

        HashMap<Integer,Worker> companyWorkers = new HashMap<>();

        //Adding two workers
        companyWorkers.put(170015,
                new Worker(
                        170015,
                        5000,
                        20,
                        "John Johnz",
                        "Project Developer"
                )
        );
        companyWorkers.put(170016,
                new Worker(
                        170016,
                        5100,
                        20,
                        "Rubi Ramos",
                        "Project Manager"
                )
        );

        //Initialize overtime hour payment for the two types of Job Titles
        SalaryCalculator.initOvertimeHourPayment();

        //Calculate Salary without extra hours
        HashMap<Integer,Integer> companyWorkersSalaries = SalaryCalculator.calculateWorkersSalary(companyWorkers);

        //Print to Console
        System.out.println("Salaries without extra hours:");
        System.out.println( companyWorkers.get(170015) +
                ",\n\tSalary: " + companyWorkersSalaries.get(170015) + " money unit" );
        System.out.println( companyWorkers.get(170016)
                + ",\n\tSalary: " + companyWorkersSalaries.get(170016) + " money unit" );

        //Adding Extra Hours
        companyWorkers.replace(170015, companyWorkers.get(170015).addExtraHour(10) );
        companyWorkers.replace(170016, companyWorkers.get(170016).addExtraHour(5) );

        //Calculate Salary without extra hours
        companyWorkersSalaries = SalaryCalculator.calculateWorkersSalary(companyWorkers);

        //Print to Console
        System.out.println("\n\nSalaries with extra hours:");
        System.out.println( companyWorkers.get(170015)
                + ",\n\tSalary: " + companyWorkersSalaries.get(170015) + " money unit" );
        System.out.println( companyWorkers.get(170016)
                + ",\n\tSalary: " + companyWorkersSalaries.get(170016) + " money unit" );
    }
}


//This class is just responsible of managing worker data
class Worker {
    private int baseSalary, workHours, extraHoursPerMonth, ID;
    private String fullName, jobTitle;

    public Worker(int id, int baseSalary, int workHours, String fullName, String jobTitle) {
        this.ID = id;
        this.baseSalary = baseSalary;
        this.workHours = workHours;
        this.fullName = fullName;
        this.jobTitle = jobTitle;
    }

    public Worker addExtraHour(int hoursPerDay){
        this.extraHoursPerMonth += hoursPerDay;
        return this;
    }

    public void resetExtraHour(){
        this.extraHoursPerMonth = 0;
    }

    public int getBaseSalary(){
        return this.baseSalary;
    }
    public int getWorkHours(){
        return this.workHours;
    }
    public int getExtraHours(){
        return this.extraHoursPerMonth;
    }
    public String getFullName(){
        return this.fullName;
    }
    public String getJobTitle(){
        return this.jobTitle;
    }

    @Override
    public String toString(){
        return this.fullName + " " + this.jobTitle;
    }
}

//This class is just responsible of calculate the salaries
final class SalaryCalculator {
    private static HashMap<String, Integer> extraHours = new HashMap<>();

    private SalaryCalculator() {
        ;
    }

    public static void initOvertimeHourPayment() {
        extraHours.put("Project Developer", 40);
        extraHours.put("Project Manager", 25);
    }

    public static HashMap<Integer, Integer> calculateWorkersSalary(HashMap<Integer, Worker> companyWorkers) {
        HashMap<Integer, Integer> companyWorkersSalaries = new HashMap<>();

        // foreach() of a HashMap class
        for (Map.Entry<Integer, Worker> workers : companyWorkers.entrySet()) {
            Integer id = workers.getKey();
            Worker worker = workers.getValue();
            int salary = worker.getBaseSalary() +
                    worker.getExtraHours() * extraHours.get(worker.getJobTitle());

            companyWorkersSalaries.put(id, salary);
        }

        return companyWorkersSalaries;
    }
}