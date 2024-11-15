package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
	public static String fractionToDecimal(int num, int den) {
        StringBuilder s = new StringBuilder();
        int q = num / den;
        int r = num % den;
        s.append(q);
        if(r == 0){
            return s.toString();
        }else{
            s.append(".");
            Map<Integer,Integer> map = new HashMap<>();
            while(r != 0){
                if(map.containsKey(r)){
                    int indexofBracket = map.get(r);
                    s.insert(indexofBracket,"(");
                    s.append(")");
                    break;
                }else{
                    map.put(r,s.length());
                    r *= 10;
                    int que = r / den;
                    r = r% den;
                    s.append(que);
                }
            }
        }

        return s.toString();
    }
	
	public static void main(String[] args) {
		fractionToDecimal(1, 2);
	}
}
