package edu.galileo;

/**
 * Created by emiliano on 31/01/17.
 *
 * A book which contains dramatic stories.
 *
 */
public class DramaBook extends Book{

    /*
     * Attributes
     */

    private String Time, Place;

    /*
     * Methods
     */

    public DramaBook(String Title, String Author, int YearOfPublication, String Time, String Place) {
        super(Title, Author, YearOfPublication);
        this.Time = Time;
        this.Place = Place;
    }

    public String getTime() {
        return this.Time;
    }

    public String getPlace() {
        return this.Place;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Time: " + this.getTime());
        System.out.println("Place: " + this.getPlace());
    }
}
