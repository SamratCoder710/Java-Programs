package com.coder.sanam;

public class BinaryNumberWithAlternatingBits {
    public static void main(String[] args) {
        BinaryNumberWithAlternatingBits binaryNumberWithAlternatingBits = new BinaryNumberWithAlternatingBits();
        boolean res = binaryNumberWithAlternatingBits.hasAlternatingBitsAlternative(5);
        System.out.println(res);
    }

    public boolean hasAlternatingBits(int n) {
        int bit = (n & 1) == 0 ? 1 : 0;
        while(n != 0){
            int currBit = (n & 1);
            if(bit == currBit){
                return false;
            }
            bit = currBit;
            n = n >> 1;
        }
        return true;
    }

    public boolean hasAlternatingBitsAlternative(int n) {
        // XOR trick
        //x = 101 ^ 010 = 111
        // 111 & 1000 = 0
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }
}
