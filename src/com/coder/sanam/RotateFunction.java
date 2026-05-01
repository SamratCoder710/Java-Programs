package com.coder.sanam;

public class RotateFunction {

    public static void main(String[] args) {
        RotateFunction rotateFunction = new RotateFunction();
        int result = rotateFunction.maxRotateFunction(new int[]{4, 3, 2, 6});
        System.out.println(result);
    }

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int F = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            F += (i * nums[i]);
        }

        int maxSum = F;
        for(int i=1;i<n;i++){
            F = F + sum - n*nums[n-i];
            maxSum = Math.max(maxSum, F);
        }
        return maxSum;
    }


    public int maxRotateFunctionTLE(int[] nums) {
        int n = nums.length;
        int maxSum = totalSum(nums);
        for (int i = 1; i < n; i++) {
            rotateByOne(nums);
            maxSum = Math.max(maxSum, totalSum(nums));
        }
        return maxSum;
    }

    private int totalSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (i * nums[i]);
        }
        return sum;
    }

    private void rotateByOne(int[] nums) {
        int n = nums.length;
        int lastElement = nums[n - 1];
        for (int i = n - 1; i >= 1; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = lastElement;
    }

    private void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // for k > n
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
