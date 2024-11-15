package com.coder.sanam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicographicalOrder {
    public static void main(String[] args) {
        List<Integer> integers = lexicalOrder(13);
        integers.forEach(System.out::println);
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer>  result = new ArrayList<>();
        for(int startnum = 1;startnum<=n;startnum++){
            solve(startnum,n,result);
        }
        return result;
    }



    private static void solve(int currNum, int n,List<Integer> result){
        if(currNum>n){
            return;
        }
        result.add(currNum);
        for(int i=0;i<=9;i++){
            int appendNum = currNum *10+i;
            solve(appendNum,n,result);
        }
    }
}
