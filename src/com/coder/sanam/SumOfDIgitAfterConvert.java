package com.coder.sanam;

public class SumOfDIgitAfterConvert {

    public static void main(String[] args) {
        System.out.println(getLucky("leetcode",2));
    }

    public static int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(char ch :s.toCharArray()){
            sb.append(ch - 'a'+1);
        }

        while(k>0){
            int sum = 0;
            for(char ch : sb.toString().toCharArray()){
                sum += ch - '0';
            }
            sb = new StringBuilder();
            sb.append(sum);
            k--;
        }
        return Integer.parseInt(sb.toString());
    }
}
