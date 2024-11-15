package com.coder.sanam;

import java.util.*;

public class ReArrangeElementsBySign {
	
	public static int[] rearrangeArray(int[] nums) {
        List<Integer> positiveArr = new ArrayList<>();
        List<Integer> negativeArr = new ArrayList<>();
        for(int num:nums){
            if(num>0){
                positiveArr.add(num);
            }else{
                negativeArr.add(num);
            }
        }

        
        int[] result = new int[nums.length];
        int idx;
        for(idx=0;idx<Math.min(positiveArr.size(), negativeArr.size());idx++){
            result[2*idx] = positiveArr.get(idx);
            result[2*idx + 1] = negativeArr.get(idx);
        }
        int index =  2*idx;
        for(int k=idx;k<positiveArr.size();k++) {
        	result[index] = positiveArr.get(k);
        	index++;
        }
        
        for(int m=idx;m<negativeArr.size();m++) {
        	result[index] = negativeArr.get(m);
        	index++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] rearrangeArray = rearrangeArray(new int[] {1,2,3,-4,-3,5,-2,-9,-10,-11,-12});
		for(int i:rearrangeArray) {
			System.out.print(i+"::");
		}
	}

}
