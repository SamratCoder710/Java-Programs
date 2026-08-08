package com.coder.sanam.misc;

import java.util.HashSet;
import java.util.Set;

public class NoOfUniqueXORTripletsII {

    static void main() {
        NoOfUniqueXORTripletsII noOfUniqueXORTripletsII = new NoOfUniqueXORTripletsII();
        int result = noOfUniqueXORTripletsII.uniqueXorTriplets(new int[]{6,7,8,9});
        System.out.println(result);
    }

    public int uniqueXorTripletsBruteForce(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                for(int k=j;k<n;k++){
                    set.add(nums[i] ^ nums[j] ^ nums[k]);
                }
            }
        }
        return set.size();
    }

    public int uniqueXorTripletsN3(int[] nums) {
        Set<Integer> pairs = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                pairs.add(nums[i] ^ nums[j]);
            }
        }

        Set<Integer> triplets = new HashSet<>();
        for(int pair : pairs){
            for(int num : nums){
                triplets.add(pair ^ num);
            }
        }

        return triplets.size();
    }


    public int uniqueXorTriplets(int[] nums) {

        int max = nums[0];
        for(int num : nums){
            max = Math.max(num, max);
        }

        int ans = 1 ;// 2^ 0
        while(ans <= max){
            ans <<= 1;
        }


        Set<Integer> pairs = new HashSet<>(ans);
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                pairs.add(nums[i] ^ nums[j]);
            }
        }

        Set<Integer> triplets = new HashSet<>(ans);
        for(int pair : pairs){
            for(int num : nums){
                triplets.add(pair ^ num);
            }
        }

        return triplets.size();
    }


}
