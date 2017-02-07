package edu.galileo;

import java.util.ArrayList;

/*
 * The implementation should be open for extension
 * but closed for modification.
 */

public class OpenClosed {

    private static ArrayList<PaperWork> universityProcedures = new ArrayList<>();
    private static int idCounter = 17000;

    public static void main(String[] args) throws Exception{
        // Inscriptions
        newInscription(new FirstYearStudent("Personal Identity Document Data"));
        newInscription(new ReEntryStudent("14101010"));
        newInscription(new TransferredStudent("Previous Study on X University"));

        System.out.println("\nProcedures:");

        for (PaperWork procedure: universityProcedures) {
            System.out.println(procedure);
        }
    }

    // Interface instance
    public static void newInscription(Inscription inscription){
        universityProcedures.add( inscription.procedure(idCounter) );
        idCounter++;
    }
}


class PaperWork {
    private int ID;
    private boolean automated;
    private String state, typeOfProcedure, information;

    public PaperWork(int id, boolean automated, String state, String typeOfProcedure, String information) {
        this.ID = id;
        this.automated = automated;
        this.state = state; // "InProcess" "Aproved" "Rejected"
        this.typeOfProcedure = typeOfProcedure; // "Inscription" "AssignCourses" "UnassignCourse" ...
        this.information = information; // Some data to Store
    }

    public String toString(){
        return this.ID + " " + this.state + " " + typeOfProcedure + " " +
                ( (automated) ? "Automated" : "Manual" ) +
                "\n\t" + this.information;
    }
}

interface Inscription {
    PaperWork procedure(int ID);
}

class FirstYearStudent implements Inscription {
    private String personalIdentityDocument;
    public FirstYearStudent(String personalIdentityDocument){
        this.personalIdentityDocument = personalIdentityDocument;
    }
    public PaperWork procedure(int ID) {
        System.out.println("Inscription of New Student");
        return new PaperWork(
                ID,
                false,
                "InProcess",
                "Inscription",
                personalIdentityDocument
        );
    }
}

class ReEntryStudent implements Inscription {
    private String studentId;
    public ReEntryStudent(String studentId){
        this.studentId = studentId;
    }
    public PaperWork procedure(int ID) {
        System.out.println("Inscription of Re-Entry Student");
        return new PaperWork(
                ID,
                true,
                "InProcess",
                "Inscription",
                studentId
        );
    }
}

class TransferredStudent implements Inscription {
    private String previousStudies;
    public TransferredStudent(String previousStudies){
        this.previousStudies = previousStudies;
    }
    public PaperWork procedure(int ID) {
        System.out.println("Inscription of Transferred Student");
        return new PaperWork(
                ID,
                false,
                "InProcess",
                "Inscription",
                previousStudies
        );
    }
}
