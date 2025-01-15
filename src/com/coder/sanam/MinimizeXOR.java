package com.coder.sanam;

public class MinimizeXOR {

    public static void main(String[] args) {
        MinimizeXOR minimizeXOR = new MinimizeXOR();
        int i = minimizeXOR.minimizeXor(3, 5);
        System.out.println(i);
    }

    public int minimizeXor(int num1, int num2) {
        int setBitCount = 0;
        while(num2>0){
            setBitCount += (num2 &1);
            num2 >>= 1;
        }

        //A XOR B = C for C to be minimal A set bits should be same as B set bits

        int bitPosition = 31;
        int X = 0;

        while (setBitCount > 0 && bitPosition >= 0) {
            if ((num1 & (1 << bitPosition)) != 0) { // If A has a set bit
                X |= (1 << bitPosition); // Set the corresponding bit in X
                setBitCount--;
            }
            bitPosition--;
        }

        // If more set bits are needed, place them in the lowest available positions
        bitPosition = 0;
        while (setBitCount > 0) {
            if ((X & (1 << bitPosition)) == 0) { // If the bit is not already set
                X |= (1 << bitPosition);
                setBitCount--;
            }
            bitPosition++;
        }
        return X;
    }
}
