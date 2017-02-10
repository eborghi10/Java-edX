package edu.galileo;

/**
 * Created by emiliano on 10/02/17.
 */

import java.util.ArrayList;

public class MyClass {

    private int var;
    private String name;
    private ArrayList<Integer> moreNumbers = new ArrayList<>();

    public MyClass(){
        this.var = 0;
        this.name = "";
    }

    public void setVar(int number){
        this.var = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoreNumbers(Integer number) {
        this.moreNumbers.add(number);
    }

    public String toString() {

        return ("\n\nClass\n\tVar: " + this.var
                + "\n\tName: " + this.name
                + "\n\tMoreNumbers: " + this.moreNumbers);
    }
}
