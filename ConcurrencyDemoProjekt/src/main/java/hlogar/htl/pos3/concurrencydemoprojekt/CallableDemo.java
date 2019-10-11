/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.concurrencydemoprojekt;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hlogar
 */
public class CallableDemo {

    public static void main(String[] args) {
        byte[] b = new byte[4000000];
        new Random().nextBytes(b);

        Callable<byte[]> c = new SorterCallable(b);

        ExecutorService executor
                = Executors.newCachedThreadPool();
        
        // variante 1 - eigenständiges Warten auf das Ergebnis       
        Future<byte[]> result = executor.submit(c);

        while (!result.isDone()) {
            System.out.println("noch nicht fertig");
        } 
        try {
            System.out.println("Ergebnis Variante 1: " + result.get().toString());
        } catch (InterruptedException ex) {
            Logger.getLogger(CallableDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(CallableDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // variante 2 - Warten über Get-Methode       
        Future<byte[]> result2 = executor.submit(c);        
        try {
            System.out.println("Ergebnis Variante 2: " + result2.get().toString());
        } catch (InterruptedException ex) {
            Logger.getLogger(CallableDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(CallableDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // variante 2 - Warten über Get-Methode mit Timeout      
        Future<byte[]> result3 = executor.submit(c);        
        try {
            System.out.println("Ergebnis Variante 3: " + result3.get(2, TimeUnit.SECONDS).toString());
        } catch (InterruptedException ex) {
            Logger.getLogger(CallableDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(CallableDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            Logger.getLogger(CallableDemo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        executor.shutdown();
    }

}