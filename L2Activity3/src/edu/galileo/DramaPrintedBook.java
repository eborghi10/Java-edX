package edu.galileo;

/**
 * Created by emiliano on 31/01/17.
 *
 * Is a drama book which meets the characteristics of a printed book.
 *
 */
public class DramaPrintedBook extends DramaBook implements PrintedBook{

    private String Dimensions, Weight;

    public DramaPrintedBook(String Title, String Author, int YearOfPublication, String Time,
                            String Place, String Weight, String Dimensions) {
        super(Title, Author, YearOfPublication, Time, Place);
        this.Dimensions = Dimensions;
        this.Weight = Weight;
    }

    public String getDimensions() {
        return this.Dimensions;
    }

    public String getWeight() {
        return this.Weight;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Weight: " + getWeight());
        System.out.println("Dimensions: " + getDimensions());
    }
}
