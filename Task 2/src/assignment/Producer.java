/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Random;

/**
 * This is the Producer Thread 
 * Contains all Producer Methods 
 * 
 * @author Hamish Maritz, 1383425
 */
public class Producer implements Runnable {

    // Initializes Objects
    private Buffer buffer; // Creates a new Buffer
    Random rand = new Random(); // Creates a new Random Generator
    // Gets the Thread ID from the Current Thread
    long threadID = Thread.currentThread().getId();

    // Constructor for the Producer Class
    public Producer(Buffer b) {
        buffer = b;
    }

    /**
     * Run Method that inserts an Item into the Buffer
     * 
     */
    @Override
    public void run() {
        
        // While Loop that Inserts an Item into the Buffer
        while (true) {
            try {
                System.out.println("Thread Sleeping");

                int x = rand.nextInt(1000) + 1;
                
                Thread.sleep(x); // Thread Sleeps for Variable X Amount Defined by Rand

                int RAND_MAX = 100;
                int item = rand.nextInt(RAND_MAX) + 1; // Chooses a Random Number between RAND_MAX and 1

                buffer.insert_item(item); // Inserts Item into the Buffer
                
                // Prints out Thread ID, Value, Items in Buffer
                System.out.println("Thread ID: " + threadID + " Value: " + item + " Items In Buffer: " + buffer.toString());

            } 
            catch (InterruptedException e) {
                e.printStackTrace(); // Error Checking
            }

        }

    }

}
