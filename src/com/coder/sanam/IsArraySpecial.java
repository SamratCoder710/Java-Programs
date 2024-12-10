package com.coder.sanam;

import java.util.*;


class Pair{
    int first;
    int second;

    public Pair(int first,int second){
        this.first =  first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return first == pair.first && second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
public class IsArraySpecial {

    public static void main(String[] args) {
        boolean[] arraySpecial = isArraySpecial(new int[]{3, 4, 1, 2, 6}, new int[][]{{0, 4}});
        System.out.println(Arrays.toString(arraySpecial));
    }

    //TLE
    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] isOdd = new boolean[n];
        boolean[] res = new boolean[queries.length];
        for(int i=0;i<n; i++){
            isOdd[i] = nums[i]%2 != 0;
        }
        Set<Pair> pairs = new HashSet<>();
        for(int i=0;i<n-1;i++){
            if(isOdd[i] == isOdd[i + 1]){
                pairs.add(new Pair(i,i+1));

            }
        }
        int idx = 0;
        for(int[] query: queries){
            boolean value = true;
            int fir = query[0];
            int sec = query[1];
            for(int i = fir;i<sec;i++){
                if(pairs.contains(new Pair(i,i+1))){
                    value = false;
                    break;
                }
            }
            res[idx] = value;
            idx++;
        }
        return res;
    }


    //TLE
    public static boolean[] isArraySpecialString(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] isOdd = new boolean[n];
        boolean[] res = new boolean[queries.length];
        for(int i=0;i<n; i++){
            isOdd[i] = nums[i]%2 != 0;
        }
        Set<String> pairs = new HashSet<>();
        for(int i=0;i<n-1;i++){
            if(isOdd[i] == isOdd[i + 1]){
//                pairs.add(new Pair(i,i+1));
                pairs.add(i+":"+(i+1));
            }
        }
        int idx = 0;
        for(int[] query: queries){
            boolean value = true;
            int fir = query[0];
            int sec = query[1];
            for(int i = fir;i<sec;i++){
                if(pairs.contains(i+":"+(i+1))){
                    value = false;
                    break;
                }
            }
            res[idx] = value;
            idx++;
        }
        return res;
    }


    //O(n)
    public static boolean[] isArraySpecialOptimal(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n];
        boolean[] result = new boolean[queries.length];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1];
            if ((nums[i - 1] % 2 == 0 && nums[i] % 2 == 0) ||
                    (nums[i - 1] % 2 != 0 && nums[i] % 2 != 0)) {
                prefix[i]++;
            }
        }
        // Step 2: Process each query
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            // Calculate the number of special pairs in the range
            int specialCount = prefix[right] - (left > 0 ? prefix[left] : 0);

            // If no special pairs, the result is true; otherwise, false
            result[i] = (specialCount == 0);
        }
        return result;
    }

}
