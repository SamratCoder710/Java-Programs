package com.coder.sanam;

import java.util.Arrays;

public class AddBinary {

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String res = addBinary.addBinary("1010","1011");
        System.out.println(res);
    }



    public String addBinary(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i >= 0 || j > 0){
            int sum =  carry;

            if(i >= 0) sum += s1.charAt(i--) - '0';
            if(j >= 0) sum += s2.charAt(j--) - '0';

            sb.append(sum % 2);
            carry = sum / 2;
        }

        if(carry == 1){
            sb.append("1");
        }

        return sb.reverse().toString();

    }
}
