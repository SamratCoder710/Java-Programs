package sanam.misc;

public class RemoveMaxMinFromArr {

    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
        }


        int a = (minIdx < maxIdx) ? minIdx + 1 + (n - maxIdx) :
                maxIdx + 1 + (n - minIdx);
        return Math.min(
                a,
                Math.min(
                        Math.max(minIdx, maxIdx) + 1,
                        n - Math.min(minIdx, maxIdx)
                ));
    }

    static void main() {
        RemoveMaxMinFromArr ob = new RemoveMaxMinFromArr();
        int result = ob.minimumDeletions(new int[] {1, 2, 3, 4, 5});
        System.out.println(result);
    }

}
