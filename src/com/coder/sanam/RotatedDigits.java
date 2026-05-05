package com.coder.sanam;

public class RotatedDigits {

    public static void main(String[] args) {
        RotatedDigits rotatedDigits = new RotatedDigits();
        int result = rotatedDigits.rotatedDigits(10);
        System.out.println(result);
    }

    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            boolean hasChange = false;
            boolean isValid = true;
            while (num != 0) {
                int digit = num % 10;
                if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                    hasChange = true;
                } else if (digit == 3 || digit == 4 || digit == 7) {
                    isValid = false;
                    break;
                }
                num = num / 10;
            }

            if (isValid && hasChange) {
                count++;
            }
        }
        return count;
    }

}
