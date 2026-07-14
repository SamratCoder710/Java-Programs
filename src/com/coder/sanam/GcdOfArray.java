package com.coder.sanam;

public class GcdOfArray {
    static void main() {
        GcdOfArray gcdOfArray = new GcdOfArray();
        int result = gcdOfArray.findGCD(new int[]{2,5,6,9,10});
        System.out.println(result);
    }

    public int findGCD(int[] nums) {
        int smallest = nums[0];
        int largest = nums[0];

        for(int num : nums){
            if(num < smallest){
                smallest = num;
            }

            if(num > largest){
                largest = num;
            }
        }

        return gcd(smallest, largest);
    }

    private int gcd(int a,int b){
        if(b == 0){
            return Math.abs(a);
        }
        return gcd(b, a%b);
    }
}
