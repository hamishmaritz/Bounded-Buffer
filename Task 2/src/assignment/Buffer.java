/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.concurrent.Semaphore;
import static assignment.Constants.*;

/**
 * This is the Buffer Class
 * This Contains Adding and Removing Items from the Buffer
 * Is Called from Methods insert_item() and remove_item()
 * @author Hamish Maritz, 1383425
 */
public class Buffer {

    // Variables and Objects
     // Defines the Buffer Size
    private Object[] buffer_item; // Array of Items
    private int in, out; // Items In and Items Out
    private int count; // Keeps count of Items in Buffer
    private Semaphore mutex; // Limited Access To the Buffer
    private Semaphore empty; // Empty Elements in Buffer
    private Semaphore full; // Full Elements in Buffer

    // Constructor for Initializing Variables/Objects
    public Buffer() {
        count = 0;
        in = 0;
        out = 0;
        buffer_item = new Object[BUFFER_SIZE];
        mutex = new Semaphore(1);
        empty = new Semaphore(BUFFER_SIZE);
        full = new Semaphore(0);
    }

    /**
     * The Producer Calls this Method
     *
     * @param item
     * @return
     * @throws InterruptedException
     */
    public int insert_item(Object item) throws InterruptedException {
        try{
        // item = null; // Defines Null

        empty.acquire(); // Keeps Track of Empty
        mutex.acquire(); // Exclusion

        // Adds Item to Buffer
        ++count;
        buffer_item[in] = item;
        in = (in + 1) % BUFFER_SIZE;

        mutex.release(); // Exclusion
        full.release(); // Keeps track of Buffer

        //  Buffer Information
        if (count == BUFFER_SIZE) {
            System.out.println("BUFFER FULL "
                    + "Producer inserted \"" + item
                    + "\" count=" + count + ", "
                    + "in=" + in + ", out=" + out);
        } 
        

        return 0;
        }
        catch(Exception e){
            return -1;
        }
    }

    /**
     * The Consumer Calls This Method
     *
     * @param item
     * @return
     * @throws InterruptedException
     */
    public int remove_item(Object item) throws InterruptedException {
       try {
        // item = null; // Defines Null

        
            full.acquire(); // Keeps track of Elements
            mutex.acquire(); // Exclusion
        
        
        // Removes Items from Buffer
        --count;
        buffer_item[out] = item;
        out = (out + 1) % BUFFER_SIZE;
        mutex.release(); //Exclusion
        empty.release(); // Keeps Track of Buffer

        // Buffer Information
        if (count == 0) {
            System.out.println("BUFFER EMPTY "
                    + "Consumer removed \"" + item
                    + "\" count=" + count + ", "
                    + "in=" + in + ", out=" + out);
        }

        return 0;
        }
        catch (Exception e){
            return -1;
        }
    }

    /**
     * Returns the Total Count in the Buffer
     *
     * @return
     */
    @Override
    public String toString() {
        return "Total Count:" + count;
    }
}
