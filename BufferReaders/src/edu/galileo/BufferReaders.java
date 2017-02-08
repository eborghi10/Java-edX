package edu.galileo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferReaders {

    public static void main(String[] args) throws Exception{

        BufferedReader input = null;
        BufferedWriter output = null;

        try {
            input = new BufferedReader( new FileReader(
                    "listOfFigures.txt"
            ) );
            output = new BufferedWriter( new FileWriter(
                    "listOfFiguresOut.txt"
            ) );

            int character;

            while ( (character = input.read()) != -1 ) {
                System.out.printf("0x%02X", character);
                System.out.print("\n");
                output.write(character);
            }
        } finally {
            if (input != null){
                input.close();
            }
            if (output != null){
                input.close();
            }
        }
    }
}
