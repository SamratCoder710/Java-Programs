package com.coder.sanam;

public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        int[] arr = new int[n+1];

        //arr[i] ith ugly number
        int i2=1; int i3=1; int i5 =1;
        arr[1] = 1;
        for(int i=2;i<=n;i++){
            int i2Num = arr[i2] *2;
            int i3Num = arr[i3] *3;
            int i5Num = arr[i5] *5;

            int min = Math.min(Math.min(i2Num,i3Num),i5Num);
            arr[i] = min;
            if(min == i2Num) i2++;

            if(min == i3Num) i3++;

            if(min == i5Num) i5++;
        }
        return arr[n];
    }
}
