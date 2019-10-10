/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.concurrencydemoprojekt;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hlogar
 */
public class ScheduledPoolExample {

    public static void main(String[] args) {
        try {
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            
            Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
                        
            ScheduledFuture<?> future = executor.schedule(task, 4, TimeUnit.SECONDS);
                        
            TimeUnit.MILLISECONDS.sleep(1337);
            
            long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
            System.out.printf("Remaining Delay: %sms", remainingDelay);
            System.out.println();
            
            TimeUnit.MILLISECONDS.sleep(10000);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ScheduledPoolExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
