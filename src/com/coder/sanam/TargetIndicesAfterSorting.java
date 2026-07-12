package com.coder.sanam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetIndicesAfterSorting {

    static void main() {
        TargetIndicesAfterSorting targetIndicesAfterSorting = new TargetIndicesAfterSorting();
        List<Integer> integers = targetIndicesAfterSorting.targetIndices(new int[]{1, 2, 5, 2, 3}, 2);
        System.out.println(integers);
    }

    private List<Integer> allElement(int idx, int[] arr){
        int target = arr[idx];
        int lIdx = idx;
        while(lIdx >= 0 && arr[lIdx] == target){
            lIdx--;
        }
        int rIdx = idx;
        while( rIdx < arr.length && arr[rIdx] == target){
            rIdx++;
        }

        List<Integer> list = new ArrayList<>();
        for(int i=lIdx+1 ;i<= rIdx-1;i++){
            list.add(i);
        }
        return list;
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r =n-1;

        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return allElement(mid,nums);
            }else if(nums[mid] > target){
                r = mid -1;
            }else{
                l = mid + 1;
            }
        }

        return new ArrayList<>();
    }
}
