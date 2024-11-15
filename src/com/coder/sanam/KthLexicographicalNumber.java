package com.coder.sanam;

import java.util.*;

public class KthLexicographicalNumber {

    public static void main(String[] args) {
        int kthNumber = findKthNumber(13, 2);
        System.out.println(kthNumber);
    }

    public static int count = 0;
    public static int result = 0;



    public static int findKthNumber(int n, int k) {
        for(int startnum = 1;startnum<=n;startnum++){
            if(solve(startnum,n,k)){
                break;
            }
        }
        return result;
    }

    private static boolean solve(long currNum, int n, int k){
        if(currNum>n){
            return false;
        }
        count++;
        if(count == k){
            result =(int)currNum;
            return true;
        }
        for(int i=0;i<=9;i++){
            long appendNum = currNum *10+i;
            if(appendNum>n) break;

            if(solve(appendNum,n,k)){
                return true;
            }
        }
        return false;
    }
}
