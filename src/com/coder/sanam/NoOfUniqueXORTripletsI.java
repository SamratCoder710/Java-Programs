package com.coder.sanam;

public class NoOfUniqueXORTripletsI {

    static void main() {
        NoOfUniqueXORTripletsI noOfUniqueXORTripletsI = new NoOfUniqueXORTripletsI();
        int result = noOfUniqueXORTripletsI.uniqueXorTriplets(new int[]{1, 2, 3});
        System.out.println(result);
    }

    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n<=2){
            return n;
        }

        int ans = 1; // 2^0
        while(ans <= n){
            ans *= 2; // ans <<= 1 (Multiply by 2)
        }
        return ans;
    }
}
