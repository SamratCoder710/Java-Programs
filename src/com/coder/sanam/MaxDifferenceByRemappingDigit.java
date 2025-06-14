package com.coder.sanam;

public class MaxDifferenceByRemappingDigit {
    public static void main(String[] args) {
        MaxDifferenceByRemappingDigit maxDifferenceByRemappingDigit = new MaxDifferenceByRemappingDigit();
        int i = maxDifferenceByRemappingDigit.minMaxDifference(11891);
        System.out.println(i);
    }

        public int minMaxDifference(int num) {
            String numString = Integer.toString(num);
            char[] maxNum = numString.toCharArray();
            char[] minNum = numString.toCharArray();

            char replaceWith9 = maxNum[0];
            for(char ch: maxNum){
                if(ch != '9'){
                    replaceWith9 = ch;
                    break;
                }
            }

            for(int i=0;i<maxNum.length;i++){
                if(maxNum[i] == replaceWith9){
                    maxNum[i] = '9';
                }
            }

            char replaceWith0 = minNum[0];
            for(int i=0;i<minNum.length;i++){
                if(minNum[i] == replaceWith0){
                    minNum[i] = '0';
                }
            }

            return Integer.parseInt(new String(maxNum)) - Integer.parseInt(new String(minNum));

        }
}
