/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.concurrencydemoprojekt;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hlogar
 */
public class MyFirstRunnable implements Runnable {

    public void hello(String s) {
        System.out.println(s);
    }

    public void run() {
        for (int i = 0; i < 100; i++)
        {
            hello("Im running " + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyFirstRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } // end of run()

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new MyFirstRunnable());
        t.start();
        System.out.println("Thread has been started ...");
        t.join();
        System.out.println("Thread finished");
    } // end of main()
} // end of class MyFirstRunnable   
