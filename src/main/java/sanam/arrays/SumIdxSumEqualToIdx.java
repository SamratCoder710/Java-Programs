package sanam.arrays;

public class SumIdxSumEqualToIdx {

    private int sumOfDigits(int x){
        int sum = 0;
        while(x > 0){
            int digit = x % 10;
            sum += digit;
            x = x / 10;
        }
        return sum;
    }


    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i == sumOfDigits(nums[i])){
                return i;
            }
        }
        return -1;
    }

    static void main() {
        SumIdxSumEqualToIdx s = new SumIdxSumEqualToIdx();
        int[] nums = new int[] {1,3,2};
        int result = s.smallestIndex(nums);
        System.out.println(result);
    }
}
