package com.coder.sanam;

public class ProcessStringWithSpecialOpsII {

    public static void main(String[] args) {
        ProcessStringWithSpecialOpsII processStringWithSpecialOpsII = new ProcessStringWithSpecialOpsII();
        char result = processStringWithSpecialOpsII.processStr("cd%#*#", 3);
        System.out.println(result);
    }

    public char processStr(String s, long k) {
        int n = s.length();
        long L = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                L = L * 2;
            } else if (ch == '*') {
                if (L > 0) {
                    L--;
                }
            } else if (ch == '%') {
                continue;
            } else {
                L++;
            }
        }

        if (k >= L) {
            return '.';
        }

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '#') {
                L = L / 2;
                if (k >= L) {
                    k = k - L;
                }

            } else if (ch == '%') {
                k = L - k - 1;
            } else if (ch == '*') {
                L++;
            } else {
                L--;
            }

            if (k == L) {
                return s.charAt(i);
            }
        }
        return '.';
    }
}
