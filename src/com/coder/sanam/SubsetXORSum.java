package com.coder.sanam;

import java.util.ArrayList;
import java.util.List;

public class SubsetXORSum {

    public static void main(String[] args) {
        int i = subsetXORSum(new int[]{1, 3});
        System.out.println("result ::"+i);
    }


    public static void solve(int[] nums,int i,List<Integer> subset,
                      List<List<Integer>> subsets){
        if(i == nums.length){
            subsets.add(new ArrayList<>(subset));
            return;
        }

        solve(nums,i+1,subset,subsets);
        subset.add(nums[i]);
        solve(nums,i+1,subset,subsets);
        subset.remove(subset.size()-1);
    }

    public static int subsetXORSum(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        solve(nums,0,subset,subsets);
        System.out.println(subsets);
        int resultSum = 0;
        for(List<Integer> sub : subsets){
            int xorRes = 0;
            for(int i:sub){
                xorRes ^= i;
            }
            resultSum += xorRes;
        }
        return resultSum;
    }

}

