package edu.galileo;

public class DependencyInversion {

    /*
     * High-level modules should not depend upon low-level modules.
     */

    public static void main(String[] args) throws Exception {
        // Graphic UserInterface
        UserInterface.getUserInput( new Graphic() );
        UserInterface.sendToUserOutput( new Graphic() );

        System.out.println();

        // Command Line or Terminal UserInterface
        UserInterface.getUserInput( new CommandLine() );
        UserInterface.sendToUserOutput( new CommandLine() );
    }
}


final class UserInterface {
    private UserInterface(){;}
    public static void getUserInput(Input in){
        in.getInput();
    };
    public static void sendToUserOutput(Output out){
        out.sendOutput();
    }
}

interface Input {
    public void getInput();
}

interface Output {
    public void sendOutput();
}

class Graphic implements Input, Output {
    public Graphic(){;}
    public void getInput() {
        System.out.println("Get Mouse Clicks and Movement");
    }
    public void sendOutput() {
        System.out.println("Show data Graphically");
    }
}

class CommandLine implements Input, Output {
    public CommandLine(){;}
    public void getInput() {
        System.out.println("Get Commands");
    }
    public void sendOutput() {
        System.out.println("Print data to terminal");
    }
}