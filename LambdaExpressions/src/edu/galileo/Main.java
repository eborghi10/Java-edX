package edu.galileo;

public class Main {
    // Creates 2 methods to test the implementation

    /**
     * Java old days demonstration
     */
    public void doItInTheOldWay() {
        // The actual implementation of the contract
        MyFunctionalInterface objImplementation = new MyFunctionalInterface() {
            @Override
            public void doSomething(String txt) {
                System.out.println(txt);
            }
        }; // THERE IS A SEMICOLON HERE!!!
        objImplementation.doSomething("Hello, in the old way!");
    }

    /**
     * Java 8 implementation of a Lambda expression
     *
     */
    public void doItWithLambdas() {
        // Behavior (implementation) definition
        MyFunctionalInterface objImplementationOne = (String x) -> System.out.println(x);
        // Invoking the definition
        objImplementationOne.doSomething("Hello, with Lambda expressions!");

        MyFunctionalInterface objImplementationTwo = x -> System.out.println("\n> " + x);
        objImplementationTwo.doSomething("Hello, from a short syntax!");

        MyFunctionalInterface objImplementationThree = x -> {
            System.out.println("\nHello, from complex syntax! ");
            System.out.println(x);
            System.out.println("Bye, from complex syntax! ");
        };
        objImplementationThree.doSomething("Inside this...");

        // Reusing the third behavior: receives the behavior as parameter
        doSomethingHighOrder(objImplementationThree);
    }

    /**
     * High-order function that receives a behavior as parameter
     * @param behavior
     */
    public void doSomethingHighOrder(MyFunctionalInterface behavior) {
        behavior.doSomething("Using a high-order function");
    }

    public static void main(String[] args) {
        Main mainInstance = new Main(); // It has the SAME name as the public class

        // Calling the old implementation
        mainInstance.doItInTheOldWay();

        // Calling the lambda implementation
        mainInstance.doItWithLambdas();

        // Calling the behavior inside the main()
        System.out.println("");
        MyFunctionalInterface aBehavior = System.out::println;
        mainInstance.doSomethingHighOrder(aBehavior);

        MyFunctionalInterface bBehavior = x -> {
            x = "\nDoing something ".concat(x);
            System.out.println(x + "\nMaking Java great again");
        };
        mainInstance.doSomethingHighOrder(bBehavior);
    }
}
