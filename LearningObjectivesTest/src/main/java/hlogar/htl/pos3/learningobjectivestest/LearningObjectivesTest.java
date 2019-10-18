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
public class LearningObjectivesTest {

    public static void main(String[] args) {

            String[] txt = {"This", "is", "a", "stream", "demo"};
            
            String result = Arrays.stream(txt)
                    .filter(s -> s.length() > 3)
                    .map(String::toUpperCase)
                    .map(s2 -> s2.substring(0, 1))
                    .sorted()
                    .reduce("X", (a, b) -> a + b + a + " ");
            System.out.println(result);
            
            String[] txt2 = {"This", "is", "a", "stream", "demo"};
            
            /*
            String result2 = Arrays.stream(txt2)
            
            
            System.out.println(result2);
            */
            ArrayList<Person> ar = new ArrayList<>();
            ar.add(new Person(4739, "Mickey Maus", "1010", "Wien"));
            ar.add(new Person(8412, "Donald Duck", "8020", "Graz"));
            ar.add(new Person(1393, "Dagobert Duck", "5020", "Entenhausen"));
            ar.add(new Person(3912, "Gustav Gans", "1010", "Wien"));
            
            
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
            Logger.getLogger(LearningObjectivesTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(LearningObjectivesTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
