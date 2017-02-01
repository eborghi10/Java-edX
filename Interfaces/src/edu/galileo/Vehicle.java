package edu.galileo;

/**
 * Created by emiliano on 30/01/17.
 */
public interface Vehicle {
    /*
     * DECLARE (not DEFINE) two methods to identify the
     * object that is instantiated with the interface.
     *
     * The "Public" modifier in the following methods is
     * redundant, so, can be avoided.
     */

    String getTransportType();
    boolean hasWheels();
}
