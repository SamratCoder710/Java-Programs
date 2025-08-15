package com.coder.sanam;

public class Largest3SameDigitNumber {

    public static void main(String[] args) {
        Largest3SameDigitNumber largest3SameDigitNumber = new Largest3SameDigitNumber();
        System.out.println(largest3SameDigitNumber.largestGoodInteger("6777133339"));
    }

    public String largestGoodInteger(String num) {
        String result = "";
        int a = 0,b=1,c=2;
        int size = num.length();
        while(c<size){
            char char_1 = num.charAt(a);
            char char_2 = num.charAt(b);
            char char_3 = num.charAt(c);
            if(char_1 == char_2 && char_2 == char_3){
//                String combined = new StringBuilder().append(char_1).append(char_2).append(char_3).toString();

                char[] arr = {char_1, char_2, char_3};
                 String combined = new String(arr);
//                 String combined = "" + char_1  + char_2  + char_3;
                result = combined.compareTo(result) > 0 ? combined : result;
            }
            a++;
            b++;
            c++;
        }
        return result;
    }
}
