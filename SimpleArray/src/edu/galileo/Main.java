package edu.galileo;

public class Main {

    public static void main(String[] args) {

        String[] maleStudents = new String[5];

        maleStudents[0] = "James";
        maleStudents[1] = "John";
        maleStudents[2] = "David";
        maleStudents[3] = "Joseph";
        maleStudents[4] = "Charles";

        System.out.println("Male students: ");

        for (int seq = 0; seq < maleStudents.length; seq++) {
            // If you don't use the first print(), the "seq" will
            // be printed wrong
            System.out.print("\t");
            System.out.println( (seq + 1) + "." + maleStudents[seq] );
        }

        // Another way to declare arrays
        String femaleStudents[] = {
                "Mary",
                "Susan",
                "Michelle",
                "Sarah",
                "Ashley"
        };

        System.out.println("\n\nFemale students: ");

        for (int seq = 0; seq < femaleStudents.length; seq++) {
            System.out.print("\t");
            System.out.println( (seq + 1) + "." + femaleStudents[seq] );
        }

        String[] studentList = new String[] {
                "Jason",
                "Gloria",
                "Paul",
                "Lisa"
        };

        System.out.println("\n\nOther students: ");

        // Another way to print strings
        int seq = 1;
        for (String student:studentList) {
            System.out.print("\t");
            System.out.println( seq + "." + student );
            seq++;
        }
    }
}
