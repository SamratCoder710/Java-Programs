package com.coder.sanam;

import java.util.Arrays;
import java.util.Comparator;

public class FindSubSequenceOfLengthKwithLargestSum {

    public static void main(String[] args) {
        FindSubSequenceOfLengthKwithLargestSum findSubSequenceOfLengthKwithLargestSum = new FindSubSequenceOfLengthKwithLargestSum();
        int[] ints = findSubSequenceOfLengthKwithLargestSum.maxSubsequence(new int[]{-1,-2,3,4}, 3);
        Arrays.stream(ints).forEach(System.out::println);
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int size = nums.length;
        int[][] idxNum = new int[size][2];
        for(int i=0;i<size;i++){
            idxNum[i][0] = i;
            idxNum[i][1] = nums[i];
        }
        Arrays.sort(idxNum, (o1, o2) -> o2[1] - o1[1]);
        Arrays.sort(idxNum,0,k, Comparator.comparingInt(o -> o[0]));
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = idxNum[i][1];
        }
        return result;

    }
}
