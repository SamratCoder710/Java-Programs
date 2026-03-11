package com.coder.sanam;

public class ComplementBase10 {
    public static void main(String[] args) {
        ComplementBase10 complementBase10 = new ComplementBase10();
        int i = complementBase10.bitwiseComplement(10);
        System.out.println(i);
    }

    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int result = 0;
        int power = 0;
        while(n != 0){
            int bit = n & 1;
            int reverse = 1 - bit;
            result |= (reverse << power);
            power++;
            n = n >> 1;
        }
        return result;
    }

    public int bitwiseComplementApproach(int n) {
        if(n == 0) return 1;
        int bits = (int)(Math.log(n) / Math.log(2)) + 1;
        int mask = (1 << bits) - 1;
        return n ^ mask ;
    }


    public int bitwiseComplementAlternativeApproach(int n) {
        if(n == 0) return 1;
        int mask = 1;

        while(mask < n){
            mask = (mask << 1) | 1; // build mask 1111..
        }
        return n ^ mask ;
    }

}
