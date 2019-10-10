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
        Future<byte[]> result = executor.submit(c);
        

    }

}
