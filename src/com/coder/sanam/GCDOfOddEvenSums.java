package com.coder.sanam;

public class GCDOfOddEvenSums {

    static void main() {
        GCDOfOddEvenSums gcdOfOddEvenSums = new GCDOfOddEvenSums();
        int result = gcdOfOddEvenSums.gcdOfOddEvenSums(4);
        System.out.println(result);
    }

    public int gcdOfOddEvenSums(int n) {
        int sumOdd = n * n;
        int sumEven = n *(n+1);
        return gcd(sumOdd, sumEven);
    }

    private int gcd(int a, int b){
        if(b == 0){
            return Math.abs(a);
        }
        return gcd(b, a%b);
    }
}
