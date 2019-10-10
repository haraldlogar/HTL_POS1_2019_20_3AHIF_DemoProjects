/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.concurrencydemoprojekt;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author hlogar
 */
public class Task implements Runnable {
    private String name;
    
    public Task(String name)  {
        this.name = name; 
    }
    
    public String getName() { 
        return name; 
    }
    
    public void run() {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Executing : " + name);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
