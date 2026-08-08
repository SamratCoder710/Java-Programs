package com.coder.sanam.ArraySumImplementation;

import com.coder.sanam.MergeSortImplementation.MergeSortAlgorithm;
import com.coder.sanam.MergeSortImplementation.ParallelMergeSortAlgorithm;

import java.util.Arrays;
import java.util.Random;

public class TestArraySum {

    public static void main(String[] args) {
        Random random = new Random();
        int n = 4* 10000000;
        int threads = Runtime.getRuntime().availableProcessors();
        int[] input = new int[n];

        for(int i=0;i<input.length;i++){
            input[i] = random.nextInt(n);
        }

        int[] copyInput = new int[n];
        System.arraycopy(input, 0, copyInput, 0, input.length);

        //PARALLEL EXECUTION
        long start = System.currentTimeMillis();
        ParallelArraySum parallelArraySum = new ParallelArraySum(input);
        int sum = parallelArraySum.getSum();
        System.out.println(sum);
        long end = System.currentTimeMillis();
        System.out.println(" Parallel execution ::");
        System.out.println(end-start);


        //SEQUENTIAL EXECUTION

        start = System.currentTimeMillis();
        SequentialArraySum sequentialArraySum = new SequentialArraySum(input);
        int newSum = parallelArraySum.getSum();
        System.out.println(newSum);
        end = System.currentTimeMillis();
        System.out.println(" Sequential execution ::");
        System.out.println(end-start);
    }
}
