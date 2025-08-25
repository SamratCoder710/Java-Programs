package com.coder.sanam;

import java.util.ArrayList;
import java.util.List;

public class LongestSubArray1sWithDeletingOneElement {

    public static void main(String[] args) {
        LongestSubArray1sWithDeletingOneElement obj = new LongestSubArray1sWithDeletingOneElement();
        int[] nums = {1,1,0,1};
        System.out.println(obj.longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        for(int idx = 0; idx < nums.length; idx++){
            if(nums[idx] == 0){
                list.add(idx);
            }
        }
        list.add(nums.length);

        if(list.size() == 2) return nums.length - 1;
        int max = 0;
        for(int i = 2; i < list.size() ; i += 2) {
            max = Math.max(max, list.get(i) - list.get(i - 2) - 2);
        }

        for(int i=3; i < list.size(); i += 2) {
            max = Math.max(max, list.get(i) - list.get(i - 2) - 2);
        }
        return max;
    }

}
