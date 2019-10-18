/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.forkjoindemo;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author hlogar
 */
public class SumTask extends RecursiveTask<Long> {

    private static final int SEQUENTIAL_THRESHOLD = 50000;

    private List<Long> data;

    public SumTask(List<Long> data) {
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
    protected Long compute() {
        if (data.size() <= SEQUENTIAL_THRESHOLD) { // base case
            long sum = computeSumDirectly();
            System.out.format("Sum of %s: %d\n", data.toString(), sum);
            return sum;
        } else { // recursive case
            // Calcuate new range
            int mid = data.size() / 2;
            SumTask firstSubtask
                    = new SumTask(data.subList(0, mid));
            SumTask secondSubtask
                    = new SumTask(data.subList(mid, data.size()));

            firstSubtask.fork(); // queue the first task

            // Return the sum of all subtasks
            return secondSubtask.compute()
                    + firstSubtask.join();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();

        List<Long> data = random
                .longs(1000, 1, 5)
                .boxed()
                .collect(toList());

        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(data);
        System.out.println("Sum: " + pool.invoke(task));
    }
}
