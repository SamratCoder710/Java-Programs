package com.coder.sanam;

public class NumberAfterDoubleReversal {

    public static void main(String[] args) {
        NumberAfterDoubleReversal numberAfterDoubleReversal = new NumberAfterDoubleReversal();
        boolean res = numberAfterDoubleReversal.isSameAfterReversals(1800);
        System.out.println(res);

    }
    public boolean isSameAfterReversalsOptimal(int num) {
        return num == 0 || (num % 10 != 0);
    }


    public boolean isSameAfterReversals(int num) {
         int reverse = reverse(num);
         int secondReverse = reverse(reverse);
         return secondReverse == num;
    }

    private int reverse(int x){
        int res = 0;
        while(x != 0){
            int digit = x% 10;
            res = res * 10 + digit;
            x = x/10;
        }
        return res;
    }
}
