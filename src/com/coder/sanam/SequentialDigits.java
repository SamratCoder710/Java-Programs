package com.coder.sanam;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    static final int[] que = new int[45];

    static{
        int n = 0;
        for(int i=1;i<10;i++){
            que[n++] = i;
        }

        for(int i=0;i<n;i++){
            int d = que[i] % 10;

            if(d < 9){
                que[n++]  = (que[i] * 10) + d + 1;
            }
        }
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        for(int x : que){
            if(x >= low && x <= high){
                result.add(x);
            }
        }
        return result;


    }

    static void main() {
        SequentialDigits seq = new SequentialDigits();
        seq.sequentialDigits(100, 300).forEach(System.out::println);
    }




}
