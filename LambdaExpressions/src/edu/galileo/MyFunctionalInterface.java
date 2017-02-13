package edu.galileo;

/**
 * Created by emiliano on 13/02/17.
 *
 * A simple contract to implement a behavior
 *
 */

@FunctionalInterface
public interface MyFunctionalInterface {
    // This interface MUST contain only one abstract method

    /**
     * The actual functional contract
     *
     * @param txt
     */
    abstract void doSomething(String txt);
}
