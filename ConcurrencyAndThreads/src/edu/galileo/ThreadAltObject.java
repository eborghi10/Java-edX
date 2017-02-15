package edu.galileo;

/**
 * Created by emiliano on 14/02/17.
 *
 * Thread 2 implementation
 *
 */
public class ThreadAltObject implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello, from Thread 2");
/*
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1500); // Once per second
            } catch (InterruptedException ie) {
                System.out.println("Thread 2 has been interrupted");
                Thread.currentThread().interrupt();
                return;
            }
            System.out.println("[2] : " + i);
        }
*/
        for (int i = 0; i < 2_147_483_647; i++) {
            if (i % 10_000_000 == 0) {
                System.out.println("[2] : " + i);
            }
            if (Thread.interrupted()) {
                System.out.println("Thread 2 has been interrupted");
                break;
            }
        }
    }
}
