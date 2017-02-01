package edu.galileo;

/**
 * Created by emiliano on 31/01/17.
 *
 * Is a science fiction book which meets the characteristics of an eAudioBook
 *
 */
public class ScienceFictioneAudioBook extends ScienceFictionBook implements eBook, eAudioBook {

    private int NumberOfTracks;
    private String Size;

    public ScienceFictioneAudioBook(String Title, String Author, int YearOfPublication,
                                    String Subject, int NumberOfTracks, String Size) {
        super(Title, Author, YearOfPublication, Subject);
        this.NumberOfTracks = NumberOfTracks;
        this.Size = Size;
    }

    public int getNumberOfTracks() {
        return this.NumberOfTracks;
    }

    public String getSize() {
        return this.Size;
    }

    public void print() {
        super.print();
        System.out.println("Number of Tracks: " + getNumberOfTracks());
        System.out.println("Size: " + getSize());
    }
}
