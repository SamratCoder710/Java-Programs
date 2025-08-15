package com.coder.sanam;

public class PowerOfFour {

    public static void main(String[] args) {
        int n = 16; // Example input
        boolean result = isPowerOfFour(n);
        System.out.println(n + " is a power of 4: " + result);
    }

    public static boolean isPowerOfFour(int n) {
        // Check if n is greater than 0 and if it is a power of 2
        if (n <= 0 || (n & (n - 1)) != 0) {
            return false;
        }
        // Check if the only set bit is at an even position
        //Can be proved by induction
        //Property of power of 4 is that (n - 1) % 3 == 0
        return (n - 1) % 3 == 0;
    }

    public static boolean isPowerOfFourUsingLog(int n) {
        if (n <= 0) {
            return false;
        }
        double logValue = Math.log(n) / Math.log(4);
        return logValue == Math.floor(logValue);
    }
}
