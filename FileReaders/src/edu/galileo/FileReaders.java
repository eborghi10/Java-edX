package edu.galileo;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileReaders {

    /*
     * Just reads bytes
     */

    public static void main(String[] args) throws Exception{

        FileInputStream input = null;
        FileOutputStream output = null;

        // R & W byte per byte
        try {
            input = new FileInputStream("listOfFigures.txt");
            output = new FileOutputStream("listOfFiguresOut.txt");

            int character;
            while ( (character = input.read()) != -1 ) {
                System.out.printf("0x%02X", character);
                System.out.print("\n");
                output.write(character);
            }
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }
}
