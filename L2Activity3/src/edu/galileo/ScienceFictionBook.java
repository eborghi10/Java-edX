package edu.galileo;

/**
 * Created by emiliano on 31/01/17.
 *
 * A book which narrates possible events developed in an imaginary situation.
 *
 */
public class ScienceFictionBook extends Book{

    /*
     * Attributes
     */

    private String Subject;

    /*
     * Methods
     */

    public ScienceFictionBook(String Title, String Author, int YearOfPublication, String Subject) {
        super(Title, Author, YearOfPublication);
        this.Subject = Subject;
    }

    public String getSubject() {
        return this.Subject;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Subject: " + this.getSubject());
    }
}
