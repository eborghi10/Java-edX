package com.company;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by emiliano on 23/01/17.
 */
public class Human {
    // Attributes (characteristics)
    char gender;    // 'F' or 'M'
    String firstName, lastName;
    int idNumber;
    int yearBirth, monthBirth, dayBirth;

    // add an Object
    Human partner;

    // Constructor
    public Human(String firstName, String lastName, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    // Methods (actions)
    public void speak(String words) {
        System.out.println(words);
    }

    public void setId(int id) {
        idNumber = id;
    }

    public int getId() {
        return this.idNumber;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void addPartner(Human humanCouple) {
        this.partner = humanCouple;
        humanCouple.partner = this;
    }

    public Human getPartner() {
        return this.partner;
    }

    public void setBirthDate(int year, int month, int day) {
        this.yearBirth = year;
        this.monthBirth = month;
        this.dayBirth = day;
    }

    public int getAge() {
        Date today = new Date();

        // The following is for manage date in Java 8
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);

        int currentYear = cal.get(Calendar.YEAR);
        int age = currentYear - yearBirth;

        // 0 is january, so add 1
        int currentMonth = cal.get(Calendar.MONTH) + 1;

        if(currentMonth < monthBirth) {
            age--;
        } else if(currentMonth == monthBirth) {
            // day of the month
            int currentDay = cal.get(Calendar.DAY_OF_MONTH);
            if (dayBirth > currentDay) {
                age--;
            }
        }
        return age;
    }

    public String getPartnerName() {
        if (partner == null) {
            return "";
        } else {
            return this.getPartner().getFullName();
        }
    }
}
