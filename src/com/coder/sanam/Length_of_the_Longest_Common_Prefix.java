package com.coder.sanam;

public class Length_of_the_Longest_Common_Prefix {

    public static void main(String[] args) {
        int i = longestCommonPrefix(new int[]{1, 10, 100}, new int[]{1000});
        System.out.println(i);
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        int max = 0;
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                max = Math.max(max,compare(arr1[i],arr2[j]));
            }
        }

        return max;
    }

    private static int compare(int i1, int i2) {
        int count  = 0;
        String s1 = String.valueOf(i1);
        String s2 = String.valueOf(i2);
        int k = 0;
        while(k<Math.min(s1.length(),s2.length())){
            if(s1.charAt(k) == s2.charAt(k)){
                count++;
            }else{
                break;
            }
            k++;
        }
        return count;
    }


}
