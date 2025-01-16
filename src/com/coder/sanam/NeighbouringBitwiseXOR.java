package com.coder.sanam;

public class NeighbouringBitwiseXOR {

    public static void main(String[] args) {
        NeighbouringBitwiseXOR neighbouringBitwiseXOR = new NeighbouringBitwiseXOR();
        boolean b = neighbouringBitwiseXOR.doesValidArrayExist(new int[]{1,1,0});
        System.out.println(b);
    }

    public boolean doesValidArrayExist(int[] derived) {
        // x ^ y = z
        // (x ^ y)^ x = z ^ x
        // y = z ^ x OR z ^ x = y
        // If XOR of two elements is third element then XOR of any two elements of that combination will be the third element

        // Considering first element of Original array as 0
        int n = derived.length;
        int[] original = new int[n];
        original[0] = 0;
        for(int i=1;i<n;i++){
            original[i] = derived[i-1] ^ original[i-1];
        }
        int k = original[n - 1] ^ original[0];
        if(derived[n-1] == k){
            return true;
        }

        // Considering first element of Original array as 1
        original[0] = 1;
        for(int i=1;i<n;i++){
            original[i] = derived[i-1] ^ original[i-1];
        }
        int l = original[n - 1] ^ original[0];
        if(derived[n-1] == l){
            return true;
        }

        return false;

    }

    public boolean doesValidArrayExistOptimal(int[] derived) {
        // Since all numbers are repeated twice
        //original array :: {a,b,c,d} = {a,b} ^ {b,c} ^ {c,d} ^ {d,a}
        // XOR of all elements of derived array should be 0 if they were formed from original array {a,b,c,d}

        int xor = 0;
        for(int i:derived){
            xor ^= i;
        }
        return xor == 0;

    }



}
