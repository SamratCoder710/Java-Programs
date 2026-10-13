package sanam.bits;

import java.util.List;

public class ApplyOpsToMaximizeSumOfSquares {

    static void main() {
        ApplyOpsToMaximizeSumOfSquares maximizeSumOfSquares = new ApplyOpsToMaximizeSumOfSquares();
        int result = maximizeSumOfSquares.maxSum(List.of(2,6,5,8),2);
        System.out.println(result);
    }

    public int maxSum(List<Integer> nums, int k) {
        final long MOD = 1_000_000_007;
        int[] cnt = new int[30];
        for (int num : nums){
            for (int b = 0; b < 30; b++) {
                if((num & (1 << b)) != 0){
                    cnt[b]++;
                }
            }
        }

        long total = 0;
        while(k>0) {  // build row i of the stacked picture
            long curr = 0;
            for (int b = 0; b < 30; b++){
                if(cnt[b] > 0){
                    cnt[b]--;
                    curr = curr | (1 << b);
                }
            }
            total = (total + curr * curr) % MOD;
            k--;
        }
        return (int) total;

    }
}
