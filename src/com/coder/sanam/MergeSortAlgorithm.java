package com.coder.sanam;

import java.util.Arrays;

public class MergeSortAlgorithm {

    public static void main(String[] args) {
        int[] input = {6,7,2,1,4,3,5,8,9};
        int n = input.length;
        divideArray(input,0,n-1);

        Arrays.stream(input).forEach(System.out::println);
    }

    private static void divideArray(int[] arr,int low,int high) {

        if(low >= high){
            return;
        }
        int mid = low+ (high-low)/2;
        divideArray(arr,low,mid);
        divideArray(arr,mid+1,high);

        conquer(arr,low,mid,high);
    }

    private static void conquer(int[] arr, int low, int mid, int high) {

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
