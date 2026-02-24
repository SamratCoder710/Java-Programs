package com.coder.sanam;

import java.util.HashSet;
import java.util.Set;

public class CheckIfStringAllBinaryCodesOfLengthK {

    public static void main(String[] args) {
        CheckIfStringAllBinaryCodesOfLengthK checkIfStringAllBinaryCodesOfLengthK = new CheckIfStringAllBinaryCodesOfLengthK();
        boolean res = checkIfStringAllBinaryCodesOfLengthK.hasAllCodes("01", 1);
        System.out.println(res);
    }

    public boolean hasAllCodes(String s, int k) {
        int i =0;
        int n = s.length();
        Set<String> set = new HashSet<>();
        for(int j=0;j<n;j++){
            while((j-i+1)  > k){  //Sliding window logic should use while, not if.
                i++;
            }
            if((j-i+1) == k){
                set.add(s.substring(i,j+1));
            }
        }
        return set.size() == (1 << k);
    }
}
