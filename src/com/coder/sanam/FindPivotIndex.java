package com.coder.sanam;

public class FindPivotIndex {

    public static void main(String[] args) {
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        int result = findPivotIndex.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println(result);
    }

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        right[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }

        for (int j = n - 2; j >= 0; j--) {
            right[j] = right[j + 1] + nums[j + 1];
        }

        for (int i = 0; i < n; i++) {
            if (left[i] == right[i]) {
                return i;
            }
        }
        return -1;
    }
}
