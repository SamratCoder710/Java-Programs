package com.coder.sanam.MergeSortImplementation;

public class ParallelMergeSortAlgorithm {

    private int [] arr;

    public ParallelMergeSortAlgorithm(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void divideArray(int low, int high) {

        if(low >= high){
            return;
        }
        int mid = low+ (high-low)/2;
        divideArray(low,mid);
        divideArray(mid+1,high);

        conquer(low,mid,high);
    }

//    public static void main(String[] args) {
//        int[] input = {6,7,2,1,4,3,5,8,9};
//        int n = input.length;
//        int threads = Runtime.getRuntime().availableProcessors();
//        System.out.println("processors ::"+threads);
//        ParallelMergeSortAlgorithm parallelMergeSortAlgorithm = new ParallelMergeSortAlgorithm();
//        parallelMergeSortAlgorithm.divideArray(input,0,n-1,threads);
//
//        Arrays.stream(input).forEach(System.out::println);
//    }

    public void divideArray( int low, int high, int threads) {

        if(threads <= 1){
            divideArray(low,high);
            return;
        }
        int mid = low+ (high-low)/2;
        Thread firstHalf = createThread(low, mid, threads/2);
        Thread secondHalf = createThread(mid + 1, high, threads/2);

        firstHalf.start();
        secondHalf.start();

        try {
            firstHalf.join();
            secondHalf.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        conquer(low,mid,high);

    }

    public Thread createThread(int low, int high, int threads){
        return new Thread(){
            public void run(){
                divideArray(low,high,threads);
            }
        };
    }

    public void conquer( int low, int mid, int high) {

        int[] merged = new int[high-low+1];
        int idx1 = low;
        int idx2 = mid+1;
        int x = 0;
        while(idx1<=mid && idx2 <= high){
            if(arr[idx1] <= arr[idx2]){
                merged[x++] = arr[idx1++];
            }else{
                merged[x++] = arr[idx2++];
            }
        }

        while(idx1<=mid){
            merged[x++] = arr[idx1++];
        }

        while(idx2 <= high){
            merged[x++] = arr[idx2++];
        }

        for(int i=0,j= low;i< merged.length;i++,j++){
            arr[j] = merged[i];
        }


    }
}
