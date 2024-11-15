package com.coder.sanam;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {6,3,9,5,2,8};
		int n = arr.length;
		quickSort(arr,0,n-1);
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int[] arr,int low,int high) {
		if(low < high) {
			int pivot = partition(arr,low,high);
			
			quickSort(arr,low,pivot-1);
			quickSort(arr,pivot+1,high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low-1;
		
		for(int k=low;k<high;k++) {
			if(arr[k]<pivot) {
				i++;
				//swap
				int temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
			}
		}
		i++;
		int temp = pivot;
		arr[high] = arr[i];
		arr[i] = temp;
		return i;
	}
	
	
	
}
