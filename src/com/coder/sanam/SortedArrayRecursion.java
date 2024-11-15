package com.coder.sanam;

public class SortedArrayRecursion {

	public static void main(String[] args) {
		int[] eleArr = {1,2,5,7,9,10,14,1};
		
		System.out.println("Is Sorted ? "+isSorted(eleArr,0));
	}

	static boolean isSorted(int[] arr,int s) {
		if(s == arr.length -1) {
			return true;
		}
		return arr[s] < arr[s+1] && isSorted(arr,s+1);
		 
	}
	
	
	
}
