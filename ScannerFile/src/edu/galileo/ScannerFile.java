package edu.galileo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class ScannerFile {

    /*
     * Search for Tokens, delimited
     *
     */

    public static void main(String[] args) throws Exception {
        Scanner input = null;

        //Token per Token
        try {
            input = new Scanner( new BufferedReader(
                    new FileReader(
                            "listOfFigures.txt"
                    ) ) );

            // is another token to read?
            while( input.hasNext() ){
                System.out.print(" > " + input.next() + "\n");
            }
        } finally {
            if (input != null){
                input.close();
            }
        }
    }
}
