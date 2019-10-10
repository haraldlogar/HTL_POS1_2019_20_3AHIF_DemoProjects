/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.concurrencydemoprojekt;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author hlogar
 */
public class ThreadPoolExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
         
        for (int i = 1; i <= 5; i++) {
            Task task = new Task("Task " + i);
            System.out.println("Created : " + task.getName());
 
            executor.execute(task);
        }
        executor.shutdown();
    }
}
