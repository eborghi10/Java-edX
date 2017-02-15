package edu.galileo;

/**
 * Created by emiliano on 14/02/17.
 *
 * Thread 1 implementation
 *
 */
public class ThreadObject extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("Hello, from Thread 1");

        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000); // Once per second
            } catch (InterruptedException ie) {
                System.out.println("Thread 1 has been interrupted");
                Thread.currentThread().interrupt();
                return;
            }
            System.out.println("[1] : " + i);
        }
    }
}
