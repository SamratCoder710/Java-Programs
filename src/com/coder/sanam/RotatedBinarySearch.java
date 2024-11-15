package com.coder.sanam;

public class RotatedBinarySearch {

	public static void main(String[] args) {
		int[] arr = { 5,6,7,8,9,1,2,4};
		System.out.println(rotatedBinarySearch(arr, 0, arr.length-1, 5));
	}

	static int rotatedBinarySearch(int[] arr, int s, int e , int target) {
		
		if(s>e) {
			return -1;
		}
		int m = s + (e-s)/2;
		if(arr[m] == target) {
			return m;
		}
		
		if(arr[s] <= arr[m]){
			if(target >= arr[s] && target <=arr[m]){
				return rotatedBinarySearch(arr,s,m-1,target);
			}else {
				return rotatedBinarySearch(arr,m+1,e,target);
			}
		}
		
		if(target >= arr[m] && target <= arr[e]) {
			return rotatedBinarySearch(arr,m+1,e,target);
		}
		return rotatedBinarySearch(arr,s,m-1,target);
		 
	}
	
	
	
}
