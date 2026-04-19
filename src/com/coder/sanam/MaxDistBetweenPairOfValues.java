package com.coder.sanam;

public class MaxDistBetweenPairOfValues {


    public static void main(String[] args) {
        MaxDistBetweenPairOfValues maxDistBetweenPairOfValues = new MaxDistBetweenPairOfValues();
        int result = maxDistBetweenPairOfValues.maxDistance(new int[]{55,30,5,4,2}, new int[]{100,20,10,10,5});
        System.out.println(result);
    }

    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int maxDist = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] > nums2[j]){
                i++;
            }else{
                maxDist = Math.max(maxDist, j-i);
                j++;
            }
        }
        return maxDist;
    }

    public int maxDistanceTLE_I(int[] nums1, int[] nums2) {
        int maxDist = 0;
        for(int i=0;i<nums1.length;i++){
            for(int j=i;j<nums2.length;j++){
                if(nums1[i] > nums2[j]){
                    break;
                }

                maxDist = Math.max(maxDist, j-i);
            }
        }
        return maxDist;
    }

    public int maxDistanceTLE_II(int[] nums1, int[] nums2) {
        int maxDist = 0;
        for(int i=0;i<nums1.length;i++){
            boolean broken = false;
            for(int j=i;j<nums2.length;j++){
                if(nums1[i] > nums2[j]){
                    if(i!=j){
                        maxDist = Math.max(maxDist, j-1-i);
                    }
                    broken = true;
                    break;
                }
            }
            if(!broken){
                maxDist = Math.max(maxDist, nums2.length - 1 -i);
            }
        }
        return maxDist;
    }
}
