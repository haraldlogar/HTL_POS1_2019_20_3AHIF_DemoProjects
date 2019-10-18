package hlogar.htl.pos3.learningobjectivestest;


import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hlogar
 */
public class LearningObjectivesTest6 implements Runnable {

    public void hello(String s) {
        System.out.println(s);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            hello("Im running " + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(LearningObjectivesTest6.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } // end of run()

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new LearningObjectivesTest6());
        t.start();
        System.out.println("Thread has been started ...");
        // what happens if we remove the t.join()
        t.join();
        System.out.println("Thread finished");
    } // end of main()
    
    // console-output
    // Thread has been started ...
    // Im running 0
    // Im running 1
    // Im running 2
    // Im running 3
    // Im running 4
    // Thread finished
    
    // when we remove t.join()
    // Thread has been started ...
    // Thread finished    
    // Im running 0
    // Im running 1
    // Im running 2
    // Im running 3
    // Im running 4
}
