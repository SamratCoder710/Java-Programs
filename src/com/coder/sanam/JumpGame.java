package com.coder.sanam;

import java.util.Arrays;

public class JumpGame {
	public static boolean canJump(int[] nums) {
		Boolean[] arr = new Boolean[nums.length];
		return dp(0,nums,arr);
    }
	
	
	private static Boolean dp(int index, int[] nums,Boolean[] arr) {
		if(arr[index] != null) {
			return arr[index];
		}
		if(index == nums.length -1) {
			return true;
		}
		if(nums[index] == 0) {
			return false;
		}
		int maxJump = Math.min(nums[index], nums.length - 1 - index);
        for (int i = 1; i <= maxJump; i++) {
            if (dp(index + i, nums, arr)) {
                arr[index] = true;
                return true;
            }
        }

        arr[index] = false;
        return false;
	}


	public static void main(String[] args) {
		System.out.println(canJump(new int[] {3,2,1,0,4}));
	}

}
