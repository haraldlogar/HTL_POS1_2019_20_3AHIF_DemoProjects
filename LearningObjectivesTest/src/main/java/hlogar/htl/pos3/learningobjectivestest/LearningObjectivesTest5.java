package hlogar.htl.pos3.learningobjectivestest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
public class LearningObjectivesTest5 {

    public static void main(String[] args) {

        try {
            ExecutorService executor = Executors.newWorkStealingPool();
            List<Callable<String>> callables = Arrays.asList(
                    new SleepingCallable("task1", 19),
                    new SleepingCallable("task2", 21),
                    new SleepingCallable("task3", 18),
                    new SleepingCallable("task4", 17),
                    new SleepingCallable("task5", 22));
            String result3 = executor.invokeAny(callables);
            System.out.println(result3);
        } catch (InterruptedException ex) {
            Logger.getLogger(LearningObjectivesTest5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(LearningObjectivesTest5.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Output: task4
        // it is the first taskt which finshed - and invokeAny only waits for the first one

    }
}
