package com.coder.sanam;

public class PlusOneLeet {

    public static void main(String[] args) {

    }

    public int[] plusOneOptimized(int[] digits) {
        int n = digits.length;
        // carry can be 1 only
        boolean carry = false;
        for(int i=n-1;i>=0;i--){
            if(digits[i] == 9){
                digits[i] = 0;
                carry = true;
            }else{
                digits[i] = digits[i] + 1;
                carry =false;
                break;
            }
        }

        if(carry){
            int[] res = new int[n+1];
            res[0] = 1;
            return res;
        }
        return digits;

    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 0;
        for(int i=n-1;i>=0;i--){
            int sum = digits[i] + carry ;
            sum += (i == n-1) ? 1 : 0;
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        if(carry != 0){
            int[] res = new int[n+1];
            System.arraycopy(digits,0,res,1,n);
            res[0] = carry;
            return res;
        }
        return digits;

    }
}
