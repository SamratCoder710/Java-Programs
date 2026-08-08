package com.coder.sanam.ArraySumImplementation;

import java.util.Arrays;

public class ParallelArraySum {

    private int[] nums;
    private ParallelWorker[] workers;


    public ParallelArraySum(int[] nums) {
        this.nums = nums;
        workers = new ParallelWorker[Runtime.getRuntime().availableProcessors()];
    }

    public int[] getNums() {
        return nums;
    }

    public int getSum(){
        int threads = Runtime.getRuntime().availableProcessors();
        System.out.println("threads:::"+threads);
        int size = (int) Math.ceil(nums.length * 1.0/threads);
        System.out.println("Size:::"+size);
        for(int i=0;i<threads;i++){
            workers[i]  = new ParallelWorker(nums,0,i*size,(i+1)*size);
//            System.out.println(workers[i]);
            workers[i].start();
        }


            try {
                for(ParallelWorker worker : workers) {
                    worker.join();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            int completeSum = 0;
        for(ParallelWorker worker : workers) {
            completeSum += worker.getSum();
        }

        return completeSum;
    }
}
