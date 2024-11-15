package com.coder.sanam;

public class MajorityElement {
    public static void main(String[] args) {
        int i = majorityElement(new int[]{2,2,1,1,1,2,2});
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
