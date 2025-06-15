package com.coder.sanam;

public class MaxDiffByChangingInt {


    public static void main(String[] args) {
        MaxDiffByChangingInt maxDiffByChangingInt = new MaxDiffByChangingInt();
        int i = maxDiffByChangingInt.maxDiff(555);
        System.out.println(i);
    }

    public int maxDiff(int num) {
        String numString = Integer.toString(num);
        StringBuilder maxNum = new StringBuilder(numString);
        StringBuilder minNum = new StringBuilder(numString);

        char replaceWith9 = maxNum.charAt(0);
        for(char ch: maxNum.toString().toCharArray()){
            if(ch != '9'){
                replaceWith9 = ch;
                break;
            }
        }

        for(int i=0;i<maxNum.length();i++){
            if(maxNum.charAt(i) == replaceWith9){
                maxNum.setCharAt(i,'9');
            }
        }


        // Get min number
        char minDigit = numString.charAt(0);
        char replace = '1';

        if (minDigit == '1') {
            for (int i = 1; i < numString.length(); i++) {
                if (numString.charAt(i) != '0' && numString.charAt(i) != '1') {
                    minDigit = numString.charAt(i);
                    replace = '0';
                    break;
                }
            }
        }

        for (int i = 0; i < minNum.length(); i++) {
            if (minNum.charAt(i) == minDigit) {
                minNum.setCharAt(i, replace);
            }
        }

        return Integer.parseInt(new String(maxNum)) - Integer.parseInt(new String(minNum));


    }
}
