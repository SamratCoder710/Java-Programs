package com.coder.sanam;

public class MergeSortedArrays {
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int totalLength = m+n;
        while(n-1>=0){
            if(m-1>=0 && nums1[m-1] > nums2[n-1]){
                nums1[totalLength-1] = nums1[m-1];
                m = m-1;
                totalLength = totalLength -1;
            }else {
                nums1[totalLength -1] = nums2[n-1];
                n = n-1;
                totalLength = totalLength -1;
            }
        }
        for(int x: nums1) {
        	System.out.print(x);
        }
            
    }
	
	public static void main(String[] args) {
		merge(new int[]{2,0}, 1, new int[] {1}, 1);
	}
	
	

}
