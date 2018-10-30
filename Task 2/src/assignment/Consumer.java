/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Random;

/**
 * This is the Consumer Thread 
 * Contains all Consumer Methods
 *
 * @author Hamish Maritz 1383425
 */
public class Consumer implements Runnable {

    private Buffer buffer; // Creates a Buffer Object  
    long threadID = Thread.currentThread().getId(); // Gets the Thread ID from the Current Thread
    Random rand = new Random(); // Creates a new Random Object

    // Constructor for the Consumer Class
    public Consumer(Buffer b) {
        buffer = b;
    }

    /**
     * Run Method that removes an Item from the Buffer
     *
     */
    @Override
    public void run() {

        // While Loop that Removes an Item from the Buffer
        while (true) {
            try {
                System.out.println("Napping..");
                int x = rand.nextInt(1000) + 1;
                Thread.sleep(x);

                int RAND_MAX = 100;
                int item = rand.nextInt(RAND_MAX) + 1;

                buffer.remove_item(item);

                // Prints out which Item was Consumed in the Buffer
                System.out.println(item + " was consumed from the Buffer!");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
