package com.coder.sanam;

import java.util.Arrays;

public class MaximumCandiesAllocatedToKChildren {

    public static void main(String[] args) {
        MaximumCandiesAllocatedToKChildren obj = new MaximumCandiesAllocatedToKChildren();
        int[] candies = {5,8,6};
        long k = 3;
        System.out.println(obj.maximumCandiesBS(candies, k));
    }

    public int maximumCandies(int[] candies, long k) {
        int max = Integer.MIN_VALUE;
        long candiesCount = 0;
        for(int candy : candies){
            candiesCount += candy;
            if(candy > max){
                max = candy;
            }
        }
        if(candiesCount < k) return 0;
        for(int i = max;i>=1;i--){
            int sum = 0;
            for(int candy: candies){
                sum += (candy/i);
            }
            if(sum >= k) return i;
        }
        return 0;

    }



    public int maximumCandiesBS(int[] candies, long k) {
        int max = Integer.MIN_VALUE;
        long candiesCount = 0;
        for(int candy : candies){
            candiesCount += candy;
            if(candy > max){
                max = candy;
            }
        }
        if(candiesCount < k) return 0;
        int result = 0;
        int l = 1, r = max;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(canDistribute(candies,mid,k)){
                result = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return result;

    }

    private boolean canDistribute(int[] candies, int target,long k){
        long sum = 0;
        for(int candy: candies){
            sum += (candy/target);
        }
        return sum >= k;
    }
}
