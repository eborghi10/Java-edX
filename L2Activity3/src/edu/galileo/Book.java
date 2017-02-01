package edu.galileo;

/**
 * Created by emiliano on 31/01/17.
 *
 * A class describing all kind of books.
 *
 */
public class Book {

    /*
     * Attributes
     */

    private String Title, Author;
    private int YearOfPublication;

    /*
     * Methods
     */

    public Book(String Title, String Author, int YearOfPublication) {
        this.Title = Title;
        this.Author = Author;
        this.YearOfPublication = YearOfPublication;
    }

    public String getTitle() {
        return this.Title;
    }

    public String getAuthor() {
        return this.Author;
    }

    public int getYearOfPublication() {
        return this.YearOfPublication;
    }

    public void print() {
        System.out.println("Title: " + this.getTitle());
        System.out.println("Author: " + this.getAuthor());
        System.out.println("Year of publication: " + this.getYearOfPublication());
    }
}
