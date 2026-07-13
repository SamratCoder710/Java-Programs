package com.coder.sanam;

import java.util.Arrays;

public class FirstAndLastPosInSortedArr {

    static void main() {
        FirstAndLastPosInSortedArr firstAndLastPosInSortedArr = new FirstAndLastPosInSortedArr();
        int[] res = firstAndLastPosInSortedArr.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(res));
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while(l<=r){
            if(nums[l] == nums[r] && nums[r] == target){
                return new int[]{l,r};
            }
            int mid = l + (r-l)/2;
            if(nums[mid] < target){
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                if(nums[l] != target){
                    l = l+1;
                }
                if(nums[r] != target){
                    r = r-1;
                }
            }
        }

        return new int[]{-1,-1};
    }
}
