package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurDecimal {

    public static void main(String[] args) {
        FractionToRecurDecimal fractionToRecurDecimal = new FractionToRecurDecimal();
        String s = fractionToRecurDecimal.fractionToDecimal(4, 333);
        System.out.println(s);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        if(numerator < 0 ^ denominator < 0){
            result.append("-");
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        result.append(num/den);
        long remainder = num % den;
        if(remainder == 0){
            return result.toString();
        }

        result.append(".");
        Map<Long,Integer> map = new HashMap<>();
        while(remainder != 0){
            if(map.containsKey(remainder)){
                int indexOfBracket = map.get(remainder);
                result.insert(indexOfBracket,"(");
                result.append(")");
                break;
            }else{
                map.put(remainder ,result.length());
                remainder *= 10;
                result.append(remainder / den);
                remainder = remainder % den;

            }
        }

        return result.toString();
    }
}
