/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.forkjoindemo;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author hlogar
 */
public class SumAction extends RecursiveAction {

    private static final int SEQUENTIAL_THRESHOLD = 5;

    private List<Long> data;

    public SumAction(List<Long> data) {
        this.data = data;
    }

    private long computeSumDirectly() {

        long sum = 0;
        for (Long l : data) {
            sum += l;
        }
        return sum;
    }

    @Override
    protected void compute() {
        if (data.size() <= SEQUENTIAL_THRESHOLD) { // base case
            long sum = computeSumDirectly();
            System.out.format("Sum of %s: %d\n", data.toString(), sum);
        } else { // recursive case
            // Calcuate new range
            int mid = data.size() / 2;
            SumAction firstSubtask
                    = new SumAction(data.subList(0, mid));
            SumAction secondSubtask
                    = new SumAction(data.subList(mid, data.size()));

            firstSubtask.fork(); // queue the first task
            secondSubtask.compute(); // compute the second task
            firstSubtask.join(); // wait for the first task result

            // Or simply call
            //invokeAll(firstSubtask, secondSubtask);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();

        List<Long> data = random
                .longs(100, 1, 5)
                .boxed()
                .collect(toList());

        ForkJoinPool pool = new ForkJoinPool();
        SumAction task = new SumAction(data);
        pool.invoke(task);
    }

}
