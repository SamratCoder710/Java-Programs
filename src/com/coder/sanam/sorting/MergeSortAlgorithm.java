package com.coder.sanam.MergeSortImplementation;

public class MergeSortAlgorithm {

    private int[] arr;

    public MergeSortAlgorithm(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void mergeSort(){
        divideArray(0,arr.length-1);
    }

    private void divideArray(int low, int high) {

        if(low >= high){
            return;
        }
        int mid = low+ (high-low)/2;
        divideArray(low,mid);
        divideArray(mid+1,high);

        conquer(low,mid,high);
    }

    private void conquer(int low, int mid, int high) {

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
