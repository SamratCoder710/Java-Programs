package com.coder.sanam;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {4,3,2,1};
		selectionSort(arr,arr.length,0,0);
		System.out.println(Arrays.toString(arr));
	}

	static void bubbleSort(int r,int c,int[] arr) {
		if(r == 0) {
			return ;
		}
		
		if(c<r) {
			if(arr[c] > arr[c+1]) {
				swap(c,c+1,arr);
			}
			bubbleSort(r,c+1,arr);
		}else {
			bubbleSort(r-1,0,arr);
		}
		 
	}
	
	
	static void selectionSort(int[] arr,int r,int c,int max) {
		if(r == 0) {
			return ;
		}
		
		if(c<r) {
			if(arr[c] > arr[max]) {
				selectionSort(arr,r,c+1,c);
			}else {
				selectionSort(arr,r,c+1,max);
			}
			
		}else {
			int temp ;
			temp = arr[max];
			arr[max] = arr[r-1];
			arr[r-1] = temp;
			selectionSort(arr,r-1,0,0);
		}
		 
	}

	private static void swap(int i, int j, int[] arr) {
		int temp ;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		
	}
	
	
	
}
