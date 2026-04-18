package com.coder.sanam;

public class MirrorDistanceOfInteger {

    public static void main(String[] args) {
        MirrorDistanceOfInteger mirrorDistanceOfInteger = new MirrorDistanceOfInteger();
        int result = mirrorDistanceOfInteger.mirrorDistance(123);
        System.out.println(result);
    }

    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    private int reverse(int n){
        int reverse = 0;
        while(n>0){
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n = n/ 10;
        }
        return reverse;
    }
}
