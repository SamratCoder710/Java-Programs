package sanam.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinOpsReduceXToZero {

    static void main() {
        MinOpsReduceXToZero minOpsReduceXToZero = new MinOpsReduceXToZero();
        int minOps = minOpsReduceXToZero.minOperations(new int[]{1,1,4,2,3},5);
        System.out.println(minOps);
    }

    private int minCount;

    private void solve(int[] nums, int remain, int count, int i, int j) {
        if (remain == 0) {
            minCount = Math.min(minCount, count);
            return;
        } else if (remain < 0 || i > j || count >= minCount) {
            return;
        } else {
            solve(nums, remain - nums[i], count + 1, i + 1, j);
            solve(nums, remain - nums[j], count + 1, i, j - 1);
        }
    }

    public int minOperationsRecursive(int[] nums, int x) {
        int n = nums.length;
        minCount = Integer.MAX_VALUE;
        solve(nums, x, 0, 0, n - 1);

        if (minCount == Integer.MAX_VALUE) {
            return -1;
        }
        return minCount;
    }


    public int minOperations(int[] nums, int x) {
        // largest subArray sum =  (sum - x)
        Map<Integer, Integer> mp = new HashMap<>(); // sum Index Map
        mp.put(0, -1);
        int n = nums.length;
        int sum = 0;
        for (int idx = 0; idx < n; idx++) {
            sum += nums[idx];
            mp.put(sum, idx);
        }

        if (sum < x) {
            return -1;
        }

        int targetSum = sum - x;
        sum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (mp.containsKey(sum - targetSum)) {
                res = Math.max(res, i - mp.get(sum - targetSum));
            }
        }

        return res == Integer.MIN_VALUE ? -1 : n - res;

    }


}
