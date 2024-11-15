package com.coder.sanam;

public class FirstAndLastPositionInSortedArray {

	public static int[] searchRange(int[] nums, int target) {
        int left =0,right = nums.length -1;
        while(left<=right) {
        	if(nums[left] == nums[right] && nums[right] == target) {
        		return new int[] {left,right};
        	}
        	int mid = left + (right -left)/2;
        	if(nums[mid] > target) {
        		right = mid -1;
        	}else if(nums[mid] < target) {
        		left = mid +1;
        	}else {
        		if(nums[left] != target) {
        			left = left +1;
        		}
        		if(nums[right] != target) {
        			right = right -1;
        		}
        	}
        	
        }
        return new int[] {-1,-1};
    }
	
	public static void main(String[] args) {
		int[] searchRange = searchRange(new int[] {}, 0);
		for(int x: searchRange) {
			System.out.print(x+"::");
		}
	}
}
