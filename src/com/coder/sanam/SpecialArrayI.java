package com.coder.sanam;

public class SpecialArrayI {

    public static void main(String[] args) {
        SpecialArrayI specialArrayI = new SpecialArrayI();
        boolean arraySpecialBit = specialArrayI.isArraySpecialBit(new int[]{2, 1, 4});
        System.out.println(arraySpecialBit);
    }


    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for(int i=0;i<=n-2;i++){
            if(nums[i]%2 == nums[i+1]%2){
                return false;
            }
        }

        return true;
    }

    public boolean isArraySpecialBit(int[] nums) {
        int n = nums.length;
        for(int i=0;i<=n-2;i++){
            if((nums[i]&1) == (nums[i+1] & 1)){
                return false;
            }
        }

        return true;
    }
}
