package com.coder.sanam;

public class FindKthBitInNthBinary {

    public static void main(String[] args) {
        FindKthBitInNthBinary findKthBitInNthBinary = new FindKthBitInNthBinary();
//        char kthBit = findKthBitInNthBinary.findKthBit(2, 1);
        char kthBit = findKthBitInNthBinary.findKthBitOptimize(2,1);
        System.out.println(kthBit);
    }

    public char findKthBit(int n, int k) {
        String input = prepareString(n);
        System.out.println(input);
        return input.charAt(k-1);
    }


    public char findKthBitOptimize(int n, int k) {
        if(n == 1) return '0';

        int length = (1 << n) - 1;
        int mid = (length + 1) / 2;

        if(k == mid) {
            return '1';
        }else if(k < mid) {
            return findKthBitOptimize(n - 1, k);
        }
        char ans = findKthBitOptimize(n-1, length - k +1);
        return ans == '0' ? '1' : '0';

    }

    private String prepareString(int n){
        if(n == 1){
            return "0";
        }
        String res = prepareString(n -1);
        return  res + "1"+ reverseInvert(res);
    }

    private String reverseInvert(String k){
        StringBuilder result = new StringBuilder();
        int n = k.length();
        for(int idx = n-1;idx>=0;idx--){
            char ch = k.charAt(idx);
            if(ch == '0'){
                result.append("1");
            }else{
                result.append("0");
            }
        }
        return result.toString();
    }



}
