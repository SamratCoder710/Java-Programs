package com.coder.sanam;

public class PowerOfThree {


    public static void main(String[] args) {
        PowerOfThree powerOfThree = new PowerOfThree();
        System.out.println(powerOfThree.isPowerOfThreeIterative(-1));
        System.out.println(powerOfThree.isPowerOfThreeIterative(27));
        System.out.println(powerOfThree.isPowerOfThreeIterative(0));
    }

    public boolean isPowerOfThreeIterative(int n) {
        if(n<=0) return false;
        while(n%3 == 0){
            n= n/3;
        }
        return n ==1;
    }

    public boolean isPowerOfThreeConstant(int n) {
        if(n<=0) return false;
        //Max power of 3 in this range is 3^19
        int maxPower = (int) Math.pow(3,19);
        return maxPower % n == 0;
    }

    public boolean isPowerOfThreeRecursive(int n) {
        if(n<=0) return false;
        if(n ==1) return true;
        if(n%3 != 0) return false;
        return isPowerOfThreeRecursive(n/3);
    }

    public boolean isPowerOfThreeLog(int n) {
        if(n<=0) return false;
        double ans = Math.log10(n) / Math.log10(3);
        return ans == (int) ans;
    }








}
