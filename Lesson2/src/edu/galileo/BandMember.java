package edu.galileo;

/**
 * Created by emiliano on 30/01/17.
 *
 * This class inherits from class "Human"
 *
 * NOTE: DON'T FORGET TO USE THE KEYWORD "extends"!!!
 */
public class BandMember extends Human implements Vocalist, Guitarist{

    public BandMember(String name) {
        // The "name" is passed to the parent class
        super(name);
    }

    public void printName() {
        System.out.println("Band Member " + this.name);
    }

    public void sing() {
        System.out.println("La La La");
    }

    /*
     * IT'S NOT NECESSARY TO IMPLEMENT THE METHOD playSong() BECAUSE
     * IT'S A "default" METHOD!!
     */
}
