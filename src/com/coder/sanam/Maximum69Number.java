package com.coder.sanam;

public class Maximum69Number {
    public static void main(String[] args) {
        Maximum69Number maximum69Number = new Maximum69Number();
        int i = maximum69Number.maximum69Number(9699);
        System.out.println(i);
    }

    public int reverseNumber (int num) {
        int result = 0;
        while(num != 0){
            int lastDigit = num %10;
            num = num/10;
            result = result * 10 + lastDigit;
        }

        return result;
    }

    public int maximum69Number (int num) {
       char[] numArr = String.valueOf(num).toCharArray();
       for(int i=0;i<numArr.length; i++){
           if(numArr[i] == '6'){
               numArr[i] = '9';
               break;
           }
       }
       return Integer.parseInt(new String(numArr));
    }

    public int maximum69NumberOptimized (int num) {
        int placeValue = 1;
        int placeValueSix = 0;
        int originalNum = num;
        while(num != 0){
            int lastDigit = num %10;
            if(lastDigit == 6){
                placeValueSix = placeValue;
            }
            placeValue *= 10;
            num = num/10;
        }

        return originalNum + 3* placeValueSix;
    }
}
