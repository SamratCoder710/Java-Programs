package com.coder.sanam;

public class CountingBSlidingWindow {
    public static void main(String[] args) {
        CountingBSlidingWindow countingBSlidingWindow = new CountingBSlidingWindow();
        System.out.println(countingBSlidingWindow.minimumRecolorsOptimal("WBBWWBBWBW", 7));
        System.out.println(countingBSlidingWindow.minimumRecolorsOptimal("WBWBBBW", 2));
    }

    public int minimumRecolors(String blocks, int k) {
        int len = blocks.length();
        if(len<k) return -1;
        int initialWindownBCount = 0;
        for(int i=0;i<k;i++){
            if(blocks.charAt(i) == 'B'){
                initialWindownBCount++;
            }
        }
        int maxCount = initialWindownBCount;
        for(int i=1;i<=len-k;i++){
            if(blocks.charAt(i-1) == 'B'){
                initialWindownBCount--;
            }
            if(blocks.charAt(i+k-1) == 'B'){
                initialWindownBCount++;
            }
            maxCount = Math.max(maxCount,initialWindownBCount);
        }

        return k-maxCount;
    }


    public int minimumRecolorsOptimal(String blocks, int k) {
        int len = blocks.length();
        int i=0;
        int j=0;
        int W = 0;
        int result = k;
        while(j<len){
            if(blocks.charAt(j)=='W'){
                W++;
            }

            if(j-i+1 == k){
                result = Math.min(result,W);

                if(blocks.charAt(i) == 'W'){
                    W--;
                }
                i++;
            }
            j++;
        }
        return result;
    }
}
