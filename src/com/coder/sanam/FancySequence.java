package com.coder.sanam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FancySequence {

    public static void main(String[] args) {
        Fancy fancy = new Fancy();
        fancy.append(2);
        fancy.addAll(3);
        fancy.append(7);
        fancy.multAll(2);
        int i = fancy.getIndex(0);
        int j = fancy.getIndex(1);
        System.out.println(i); // 10
        System.out.println(j); // 14
    }
}


class Fancy {
    long [] nums = new long[100001];
    int [] ins = new int[100001];
    int M = 1_000_000_007;
    int index;
    List<int[]> ops;
    public Fancy() {
        index = 0;
        ops = new ArrayList<>();
        Arrays.fill(nums,-1);
    }

    public void append(int val) {
        nums[index] = val;
        ins[index] = ops.size();
        index++;
    }

    public void addAll(int inc) {
        ops.add(new int[]{0,inc});
    }

    public void multAll(int m) {
        ops.add(new int[]{1,m});
    }

    public int getIndex(int idx) {
        if(idx >= index) return -1;
        long result = nums[idx];
        for(int i=ins[idx];i<ops.size();i++){
            int[] operation = ops.get(i);
            if(operation[0] == 0){
                result = (result + operation[1]) %M;
            }else{
                result = (result * operation[1]) %M;
            }
        }
        return (int)result;
    }
}



class FancyOptimized {
    private ArrayList<Long> val;
    private static final int M = 1_000_000_007;
    private long add , mul;
    public FancyOptimized() {
        val = new ArrayList<>();
        mul = 1;
        add = 0;
    }

    private long modPow(long x,long y,long mod){
        long res = 1;
        x = x % M;
        while(y > 0){
            if(y % 2 == 1){
                res = (res * x) % M;
            }
            y = y/2;
            x = (x * x) % M;
        }
        return res;
    }

    public void append(int val) {
        long x = ( val - add + M) % M;
        this.val.add((x * modPow(mul,M-2,M)) % M);
    }

    public void addAll(int inc) {
        add = (add + inc) % M;
    }

    public void multAll(int m) {
        mul = (mul * m) % M;
        add = (add * m) % M;
    }

    public int getIndex(int idx) {
        if (idx >= val.size()) return -1;
        return (int)((mul * val.get(idx) + add) % M);
    }
}
