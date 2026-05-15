package com.coder.sanam;

public class MinimumInRotatedSortedArr {
    public static void main(String[] args) {
        MinimumInRotatedSortedArr minimumInRotatedSortedArr = new MinimumInRotatedSortedArr();
        int min = minimumInRotatedSortedArr.findMinBinarySearch(new int[]{3, 4, 5, 1, 2});

        int minTwo = minimumInRotatedSortedArr.findMin(new int[]{3, 4, 5, 1, 2});
        System.out.println(min);
        System.out.println(minTwo);
    }

    public int findMin(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }

    public int findMinBinarySearch(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

}
