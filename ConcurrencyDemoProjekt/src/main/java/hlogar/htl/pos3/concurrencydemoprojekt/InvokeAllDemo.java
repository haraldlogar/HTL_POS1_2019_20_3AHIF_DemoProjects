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
import java.util.concurrent.Future;

/**
 *
 * @author hlogar
 */
public class InvokeAllDemo {

    public static void main(String[] args) {
        final ExecutorService pool = Executors.newFixedThreadPool(2);
        final List<? extends Callable<String>> callables = Arrays.asList(
                new SleepingCallable("quick", 500),
                new SleepingCallable("slow", 5000));
        try {
            for (final Future<String> future : pool.invokeAll(callables)) {
                System.out.println(future.get());
            }
        } catch (ExecutionException | InterruptedException ex) {
        }
        pool.shutdown();
    }
}
