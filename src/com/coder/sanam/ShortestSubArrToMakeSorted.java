package com.coder.sanam;

public class ShortestSubArrToMakeSorted {

    public static void main(String[] args) {
        System.out.println(findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5}));
    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int l =0;
        int r = n-1;
        while(l<n && arr[l]<= arr[l+1]){l++;}
        while(r>0 && arr[r]>= arr[r-1]){r--;}
        System.out.println(l+":L;  R:"+r);
        if(l>= r) return 0;
        int ans = r, left=0, right = r;
        while(left<= l){
            while(right<n && arr[right]< arr[left]){
                right++;
            }
            ans = Math.min(ans, right-left-1);
            left++;
        }
        return ans;
    }
}
