package sanam.arrays;

import java.util.Arrays;

public class MaximumAlternatingSumOfSquares {

    static void main() {
        MaximumAlternatingSumOfSquares maximumAlternatingSumOfSquares = new MaximumAlternatingSumOfSquares();
        long result = maximumAlternatingSumOfSquares.maxAlternatingSum(new int[]{1,-1,2,-2,3,-3});
        System.out.println(result);
    }

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int[] squareNums = new int[n];

        for(int i=0;i<n;i++){
            squareNums[i] = nums[i] * nums[i];
        }
        Arrays.sort(squareNums);
        long result = 0;

        for(int i=0;i<n/2;i++){
            result -= squareNums[i];
        }
        for(int i=n/2 ; i<n;i++){
            result += squareNums[i];
        }
        return result;
    }

    public long maxAlternatingSumJava8(int[] nums) {
        int n = nums.length;
        int[] squareNums = Arrays.stream(nums).map(x -> x * x).sorted().toArray();
        long negativeHalf = Arrays.stream(squareNums,0,n/2).asLongStream().sum();
        long positiveHalf  = Arrays.stream(squareNums,n/2,n).asLongStream().sum();
        return positiveHalf - negativeHalf;
    }
}
