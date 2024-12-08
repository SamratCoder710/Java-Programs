package com.coder.sanam.MergeSortImplementation;

import java.util.Random;

public class TestMergeSort {

    public static void main(String[] args) {
        Random random = new Random();
        int n = 30;
        int threads = Runtime.getRuntime().availableProcessors();
        int[] input = new int[n];

        for(int i=0;i<input.length;i++){
            input[i] = random.nextInt(n);
        }

        int[] copyInput = new int[n];
        System.arraycopy(input, 0, copyInput, 0, input.length);

        //PARALLEL EXECUTION
        long start = System.currentTimeMillis();
        ParallelMergeSortAlgorithm parallelMergeSortAlgorithm = new ParallelMergeSortAlgorithm(input);
        parallelMergeSortAlgorithm.divideArray(0,n-1,threads);

//        Arrays.stream(parallelMergeSortAlgorithm.getArr()).forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.println(" Parallel execution ::");
        System.out.println(end-start);


        //SEQUENTIAL EXECUTION

        start = System.currentTimeMillis();
        MergeSortAlgorithm mergeSortAlgorithm = new MergeSortAlgorithm(copyInput);
        mergeSortAlgorithm.mergeSort();

//        Arrays.stream(parallelMergeSortAlgorithm.getArr()).forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println(" Sequential execution ::");
        System.out.println(end-start);
    }
}
