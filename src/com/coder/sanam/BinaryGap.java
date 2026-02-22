package com.coder.sanam;

public class BinaryGap {


    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        int res = binaryGap.binaryGap(22);
        System.out.println(res);
    }

    public int binaryGap(int n) {
        int prevIdx = -1;
        int idx = 0;
        int result = 0;
        while(n != 0){
            int bit = n & 1;
            if(bit == 1 ){
                if(prevIdx != -1){
                    result = Math.max(result, idx - prevIdx);
                }
                prevIdx = idx;
            }
            idx++;
            n = n >> 1;
        }
        return result;
    }
}
