package com.coder.sanam;

public class SearchInRotatedSortedArray {
	public static int search(int[] nums, int target) {
        int left =0,right = nums.length -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[mid] ){
                //left side sorted
                if(target >= nums[left] && target < nums[mid]){
                    right = mid -1;
                }else{
                    left = mid+1;
                }
            }else{
                 if(target >= nums[left] && target > nums[mid]){
                    right = mid -1;
                }else{
                    left = mid+1;
                }
            }
        }
        return -1;
    } 

	public static void main(String[] args) {
		int search = search(new int[] {5,1,3}, 5);
		System.out.println(search);
	}
}
