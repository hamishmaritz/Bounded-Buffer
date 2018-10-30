/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 * This is the Main Method 
 * Initializes Buffer 
 * Creates Consumer,
 * Producer Threads
 * Sleeps Exit
 *
 * @author Hamish Maritz, 1383425
 */
public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("Buffer Starting...");
            Buffer buffer = new Buffer(); // Creates a new Buffer
            Thread producerThread = new Thread(new Producer(buffer)); // Creates Producer Thread
            Thread consumerThread = new Thread(new Consumer(buffer)); // Creates Consumer Thread
            Thread producerThread1 = new Thread(new Producer(buffer));
            Thread consumerThread1 = new Thread(new Consumer(buffer));
            Thread producerThread2 = new Thread(new Producer(buffer));
            Thread consumerThread2 = new Thread(new Consumer(buffer));
            Thread producerThread3 = new Thread(new Producer(buffer));
            Thread consumerThread3 = new Thread(new Consumer(buffer));
            Thread producerThread4 = new Thread(new Producer(buffer));
            Thread consumerThread4 = new Thread(new Consumer(buffer));
            Thread producerThread5 = new Thread(new Producer(buffer));
            Thread consumerThread5 = new Thread(new Consumer(buffer));
            producerThread.start(); // Starts Producer Thread
            consumerThread.start(); // Starts Consumer Thread
            producerThread1.start();
            consumerThread1.start();
            producerThread2.start();
            consumerThread2.start();
            producerThread3.start();
            consumerThread3.start();
            producerThread4.start();
            consumerThread4.start();
            producerThread5.start();
            consumerThread5.start();
            Thread.sleep(1000); // Sleeps for 1000ms
            System.exit(0); // Program Terminates
        } 
        catch (InterruptedException e) {
            e.printStackTrace(); // Error Checking/Handling
        }

    }

}
