package hlogar.htl.pos3.learningobjectivestest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hlogar
 */
public class SleepingCallable implements Callable<String> {

    private String name;
    private int zeit;

    SleepingCallable(String name, int zeit) {
        this.name = name;
        this.zeit = zeit;
    }

    public String call() {
        try {
            TimeUnit.MILLISECONDS.sleep(zeit);
           
        } catch (InterruptedException ex) {
            Logger.getLogger(SleepingCallable.class.getName()).log(Level.SEVERE, null, ex);
        }
         return name;
    }
}
