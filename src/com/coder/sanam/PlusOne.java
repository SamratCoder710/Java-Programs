package com.coder.sanam;

public class PlusOne {

    public static void main(String[] args) {
        PlusOne obj = new PlusOne();
        int[] digits = {9,9,9};
        int[] result = obj.plusOneAlternative(digits);
        for(int digit: result){
            System.out.print(digit + ",");
        }
    }
	
	public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i=len-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[len+1];
        digits[0] = 1;
        return digits;
          
    }


    public int[] plusOneAlternative(int[] digits) {
        int n = digits.length;
        boolean carry = false;
        for(int idx = n-1;idx >=0 ; idx--){
            if(digits[idx] == 9){
                digits[idx] = 0;
                carry = true;
            }else{
                digits[idx] = digits[idx] + 1;
                carry = false;
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
}
