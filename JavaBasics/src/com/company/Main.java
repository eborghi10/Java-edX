package com.company;

public class Main {

    public static void main(String[] args) {
	    // instance variables
        byte bVar = 2;
        short sVar = 10;
        int num = 200;  // 16-bit integer
        long serie = 2000;
        float currency = 2.0f;  // NOTE the "f"!!
        double moreCurrency = 3.0;
        char c = 'd';
        boolean boolVar = true;

        // class variable - Creating strings
        String stringVar = new String("hi");

        Human connie = new Human("Connie", "Smith", 'F');
        connie.setBirthDate(1987,1,22);
        connie.setId(123456);
        System.out.println(connie.getFullName() + " is " + connie.getAge() + " years old");

        Human john = new Human("John", "Brown", 'M');
        john.setBirthDate(1986, 12, 8);
        System.out.println(john.getFullName() + " is " + john.getAge() + " years old");
        connie.addPartner(john);
        System.out.println(connie.getFullName() + "'s partner is " + connie.getPartnerName());
        System.out.println(john.getFullName() + "'s partner is " + john.getPartnerName());
    }
}
