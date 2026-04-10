package com.coder.sanam;

import java.util.Arrays;

public class MinDistBtnThreeEqualElementsI {

    public static void main(String[] args) {
        MinDistBtnThreeEqualElementsI minDistBtnThreeEqualElementsI = new MinDistBtnThreeEqualElementsI();
        int result = minDistBtnThreeEqualElementsI.minimumDistance(new int[]{1,2,2,2});
        System.out.println(result);
    }


    // i < j < k
    // j - i + k - j + k - i = 2 * (k - i)
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for(int i=0; i<n;i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr,(a,b)->{
            if(a[0] == b[0]){
                return Integer.compare(a[1],b[1]);
            }
            return a[0] - b[0];
        });
        int dist = Integer.MAX_VALUE;
        for(int i=0;i<n-2;i++){
            if(arr[i][0] == arr[i+2][0]){
                dist = Math.min(dist,2 * (arr[i+2][1] - arr[i][1]));
            }
        }
        if(dist == Integer.MAX_VALUE){
            return -1;
        }
        return dist;
    }
}
