/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.concurrencydemoprojekt;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hlogar
 */
public class InvokeAny {

    public static void main(String[] args) {
        try {
            ExecutorService executor = Executors.newWorkStealingPool();
            List<Callable<String>> callables = Arrays.asList(
                    new SleepingCallable("task1", 2),
                    new SleepingCallable("task2", 1),
                    new SleepingCallable("task3", 3));
            String result = executor.invokeAny(callables);
            System.out.println(result);
        } catch (InterruptedException ex) {
            Logger.getLogger(InvokeAny.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(InvokeAny.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
