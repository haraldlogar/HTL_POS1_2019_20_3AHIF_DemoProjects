/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.forkjoindemo;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author hlogar
 */
public class ComparePerformance {

    public static void main(String[] args) {
        Random random = new Random();

        List<Long> data = random
                .longs(10_000_000, 1, 100)
                .boxed()
                .collect(toList());

        // test the summarize with fork-Join
        // remove the System.out.println in compute of SumTask
        testForkJoin(data);
        
        // test the summarize in a sequential way
        //testSequentially(data);
        
        // test the summarize with sequential- and parallel streams
        //testSequentiallyStream(data);
        //testParallelStream(data);
    }

    private static void testForkJoin(List<Long> data) {
        final long start = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(data);
        pool.invoke(task);

        System.out.println("Executed with fork/join in (ms): " + (System.currentTimeMillis() - start));
    }

    private static void testSequentially(List<Long> data) {
        final long start = System.currentTimeMillis();

        long sum = 0;
        for (Long l : data) {
            sum += l;
        }

        System.out.println("Executed sequentially in (ms): " + (System.currentTimeMillis() - start));
    }

    private static void testSequentiallyStream(List<Long> data) {
        final long start = System.currentTimeMillis();

        data.stream().reduce(0L, Long::sum);

        System.out.println("Executed with a sequential stream in (ms): " + (System.currentTimeMillis() - start));
    }

    private static void testParallelStream(List<Long> data) {
        final long start = System.currentTimeMillis();

        data.parallelStream().reduce(0L, Long::sum);

        System.out.println("Executed with a parallel stream in (ms): " + (System.currentTimeMillis() - start));
    }
}
