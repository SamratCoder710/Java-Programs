package com.coder.sanam;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] inputArr = {6,3,9,5,2,8};
		inPlaceDivide(inputArr,0,inputArr.length);
		System.out.println(Arrays.toString(inputArr));
	}

	static int[] dividePart(int[] arr) {
		if(arr.length ==1) {
			return arr;
		}
		int mid = arr.length/2;
		int[] first = dividePart(Arrays.copyOfRange(arr, 0, mid));
		int[] second = dividePart(Arrays.copyOfRange(arr, mid, arr.length));
		
		return conquer(first,second);
	 	 
	}
	
	private static int[] conquer(int[] f, int[] s) {
		int[] mix = new int[f.length + s.length];
		int i=0;
		int j=0;
		int k=0;
		
		while(i<f.length && j<s.length) {
			if(f[i]<s[j]) {
				mix[k] = f[i];
				i++;
			}else {
				mix[k] = s[j];
				j++;
			}
			k++;
		}
		
		while(i<f.length) {
			mix[k] = f[i];
			i++;
			k++;
		}
		
		while(j<s.length) {
			mix[k] = s[j];
			j++;
			k++;
		}
		
		return mix;
	}
	
	
	
	static void inPlaceDivide(int[] arr,int s,int e) {
		if(e -s == 1) {
			return ;
		}
		int mid = s +(e-s)/2;
		inPlaceDivide(arr, s, mid);
		inPlaceDivide(arr, mid, e);
		
		conquerInPlace(arr,s,e,mid);
	 	 
	}

	private static void conquerInPlace(int[] arr, int s, int e, int m) {

		int[] mix = new int[e-s];
		int i=s;
		int j=m;
		int k=0;
		
		while(i<m && j<e) {
			if(arr[i]<arr[j]) {
				mix[k] = arr[i];
				i++;
			}else {
				mix[k] = arr[j];
				j++;
			}
			k++;
		}
		
		while(i<m) {
			mix[k] = arr[i];
			i++;
			k++;
		}
		
		while(j<e) {
			mix[k] = arr[j];
			j++;
			k++;
		}
		
		for(int l =0;l< mix.length ;l++) {
			arr[s+l] = mix[l];
		}
	
		
	}

	
	
}
